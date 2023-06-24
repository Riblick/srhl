package com.example.riblick.Configs;


import com.example.riblick.Entity.Role;
import com.example.riblick.Service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomUserDetailsService userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()// I know I shouldn't do this, but I'm having trouble with it..

                .authorizeRequests()
                .antMatchers("/profile").hasAuthority(Role.STUDENT.getAuthority())
                .antMatchers("/forum/profile").hasAuthority(Role.STUDENT.getAuthority())

                .antMatchers("/forum/create/1").hasAuthority(Role.STUDENT.getAuthority())
                .antMatchers("/forum/create/2").hasAuthority(Role.STUDENT.getAuthority())
                .antMatchers("/forum/create/3").hasAuthority(Role.STUDENT.getAuthority())
                .antMatchers("/forum/create/4").hasAuthority(Role.STUDENT.getAuthority())

                .antMatchers("/forum/admin").hasAuthority(Role.ADMIN.getAuthority())
                .antMatchers("/forum/delete/admin/").hasAuthority(Role.ADMIN.getAuthority())
                .antMatchers("/forum/delete/admin/message/").hasAuthority(Role.ADMIN.getAuthority())
                .antMatchers("/forum/create/1").hasAuthority(Role.ADMIN.getAuthority())
                .antMatchers("/forum/create/2").hasAuthority(Role.ADMIN.getAuthority())

                .antMatchers("/", "/login", "/registration")
                .permitAll()

                .antMatchers("/favicon/**")
                .permitAll()

                .and()
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/forum/profile", true)
                .permitAll();

    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers(

                "/favicon/**"
        );
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}