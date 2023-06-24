package com.example.riblick.Controller;


import com.example.riblick.Entity.Message;
import com.example.riblick.Entity.Subject;
import com.example.riblick.Repository.MessageRepository;
import com.example.riblick.Repository.SubjectRepository;
import com.example.riblick.Service.MessageService;
import com.example.riblick.Service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ForumController {
    private final SubjectService subjectService;
    private final SubjectRepository subjectRepository;
    private final MessageRepository messageRepository;
    private final MessageService messageService;

    @GetMapping("/forum")
    public String forum(Principal principal, Model model) {

        model.addAttribute("subjectSelectForForum1", subjectService.listSubjectsByFormId(Long.valueOf(1)));
        model.addAttribute("subjectSelectForForum2", subjectService.listSubjectsByFormId(Long.valueOf(2)));
        model.addAttribute("subjectSelectForForum3", subjectService.listSubjectsByFormId(Long.valueOf(3)));
        model.addAttribute("subjectSelectForForum4", subjectService.listSubjectsByFormId(Long.valueOf(4)));
        model.addAttribute("user", subjectService.getUserByPrincipal(principal));

        return "forum";

    }

    @GetMapping("/forum/subject/{id}")
    public String subject_info(@PathVariable Long id, Model model, Principal principal) {
        Subject subject = subjectService.getSubjectById(id);
        model.addAttribute("user", subjectService.getUserByPrincipal(principal));

        model.addAttribute("subjectSelectForFormById", subject);
        model.addAttribute("subjectSelectForFormMessageList", subject.getMessageList());

        return "forum-select-subject";
    }

    @PostMapping("/forum/subject/{id}")
    public String subject_info_message(@PathVariable Long id, Message message, Principal principal) {
        Subject subject = subjectService.getSubjectById(id);

        messageService.saveMessage(principal, message, subject);
        return "redirect:/forum/subject/{id}";
    }

    @GetMapping("/forum/create/1")
    public String forums_select1(Model model, Principal principal) {
        model.addAttribute("user", subjectService.getUserByPrincipal(principal));

        return "form-create-1";

    }

    @GetMapping("/forum/create/2")
    public String forums_select2(Model model, Principal principal) {
        model.addAttribute("user", subjectService.getUserByPrincipal(principal));
        return "form-create-2";

    }

    @GetMapping("/forum/create/3")
    public String forums_select3(Model model, Principal principal) {
        model.addAttribute("user", subjectService.getUserByPrincipal(principal));
        return "form-create-3";

    }

    @GetMapping("/forum/create/4")
    public String forums_select4(Model model, Principal principal) {
        model.addAttribute("user", subjectService.getUserByPrincipal(principal));
        return "form-create-4";

    }

    @PostMapping("/forum/create/1")
    public String forums_create1(Subject subject, Principal principal) {

        subjectService.saveSubject(principal, subject);
        return "redirect:/forum";

    }

    @PostMapping("/forum/create/2")
    public String forums_create2(Subject subject, Principal principal) {
        subjectService.saveSubject(principal, subject);
        return "redirect:/forum";

    }

    @PostMapping("/forum/create/3")
    public String forums_create3(Subject subject, Principal principal) {
        subjectService.saveSubject(principal, subject);
        return "redirect:/forum";

    }

    @PostMapping("/forum/create/4")
    public String forums_create4(Subject subject, Principal principal) {
        subjectService.saveSubject(principal, subject);
        return "redirect:/forum";

    }

    @GetMapping("forum/profile")
    public String user_forum(Model model, Principal principal) {

        model.addAttribute("user", subjectService.getUserByPrincipal(principal));
        model.addAttribute("allSubjects", subjectService.listSubjectAll());


        return "user-forum-profile";
    }

    @GetMapping("forum/rules")
    public String user_forum_rules(Model model, Principal principal) {

        model.addAttribute("user", subjectService.getUserByPrincipal(principal));


        return "forum-yup";
    }

    @PostMapping("/forum/delete/{id}")
    public String delete_subject(@PathVariable Long id, Principal principal) {
        subjectService.deleteSubject(subjectService.getUserByPrincipal(principal), id);
        return "redirect:/forum/profile";

    }

    @PostMapping("/forum/message/delete/{id}")
    public String delete_message(@PathVariable Long id, Principal principal) {
        Long sub_id = messageRepository.findById(id).get().getSubject().getId();
        String redirect_to_subId = "redirect:/forum/subject/" + sub_id.toString();

        messageService.deleteMessage(subjectService.getUserByPrincipal(principal), id);

        return redirect_to_subId;
    }


}
