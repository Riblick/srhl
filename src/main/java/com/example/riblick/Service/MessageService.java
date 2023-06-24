package com.example.riblick.Service;

import com.example.riblick.Entity.Message;
import com.example.riblick.Entity.Subject;
import com.example.riblick.Entity.User;
import com.example.riblick.Repository.MessageRepository;
import com.example.riblick.Repository.SubjectRepository;
import com.example.riblick.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {
    private final MessageRepository messageRepository;
    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;

    public void saveMessage(Principal principal, Message message, Subject subject) {
        subject.setMessages_count(subject.getMessages_count() + 1);
        message.setUser(getUserByPrincipal(principal));
        message.setSubject(subject);

        messageRepository.save(message);

    }

    public List<Message> listMessageAll() {
        return messageRepository.findAll();
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByUsername(principal.getName());
    }


    public void deleteMessage(User userByPrincipal, Long id) {
        Message message_get_principal = messageRepository.findById(id).orElse(null);
        Subject subject = subjectRepository.findById(message_get_principal.getSubject().getId()).get();


        if (message_get_principal.getUser().getUsername().equals(userByPrincipal.getUsername())) {
            subject.setMessages_count(subject.getMessages_count() - 1);
            messageRepository.delete(message_get_principal);
        }
    }

    public void deleteMessageByAdmin(User userByPrincipal, Long id) {
        Message message_get_principal = messageRepository.findById(id).orElse(null);
        Subject subject = subjectRepository.findById(message_get_principal.getSubject().getId()).get();


        if (userByPrincipal.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {

            subject.setMessages_count(subject.getMessages_count() - 1);
            messageRepository.delete(message_get_principal);
        }
    }


}
