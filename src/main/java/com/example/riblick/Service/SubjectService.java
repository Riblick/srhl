package com.example.riblick.Service;

import com.example.riblick.Entity.Role;
import com.example.riblick.Entity.Subject;
import com.example.riblick.Entity.User;
import com.example.riblick.Repository.SubjectRepository;
import com.example.riblick.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.SQLData;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;


    public List<Subject> listSubjectsByFormId(Long formId) {

        if (formId != null) subjectRepository.findByFormId(formId);
        return subjectRepository.findByFormId(formId);

    }


    public List<Subject> listSubjectAll() {
        return subjectRepository.findAll();
    }


    public void saveSubject(Principal principal, Subject subject) {
        subject.setUser(getUserByPrincipal(principal));


        subject.setViews_count(Long.valueOf(0));
        subject.setMessages_count(Long.valueOf(0));

        subjectRepository.save(subject);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByUsername(principal.getName());
    }

    public void deleteSubject(User user, Long id) {
        Subject subject_get_principal = subjectRepository.findById(id).orElse(null);


        if (subject_get_principal.getUser().getUsername().equals(user.getUsername())) {
            subjectRepository.findById(id)
                    .ifPresentOrElse(subject -> {
                        user.removeSubject(subject);
                        userRepository.save(user);
                    }, () -> log.warn("Subject not found by id {}", id));

        }
    }

    public void deleteSubjectbyAdmin(User user, Long id) {
        Subject subject_get_principal = subjectRepository.findById(id).orElse(null);
        User subject_user = subject_get_principal.getUser();

        if (user.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            subjectRepository.findById(id)
                    .ifPresentOrElse(subject -> {
                        subject_user.removeSubject(subject);
                        userRepository.save(subject_user);

                    }, () -> log.warn("Subject not found by id {}", id));

        }
    }


    public Subject getSubjectById(Long id) {

        return subjectRepository.findById(id).orElse(null);
    }


}
