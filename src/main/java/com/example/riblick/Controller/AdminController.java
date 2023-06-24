package com.example.riblick.Controller;

import com.example.riblick.Service.MessageService;
import com.example.riblick.Service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final SubjectService subjectService;
    private final MessageService messageService;


    @GetMapping("/forum/admin")
    public String forumAdmin(Model model, Principal principal) {

        model.addAttribute("allMessages", messageService.listMessageAll());
        model.addAttribute("allSubjects", subjectService.listSubjectAll());
        model.addAttribute("user", subjectService.getUserByPrincipal(principal));


        return "forum-admin-page";
    }


    @PostMapping("/forum/delete/admin/{id}")
    public String deleteSubjectbyAdmin(@PathVariable Long id, Principal principal) {
        subjectService.deleteSubjectbyAdmin(subjectService.getUserByPrincipal(principal), id);
        return "redirect:/forum/admin";

    }

    @PostMapping("/forum/delete/admin/message/{id}")
    public String deleteMessagebyAdmin(@PathVariable Long id, Principal principal) {

        messageService.deleteMessageByAdmin(subjectService.getUserByPrincipal(principal), id);

        return "redirect:/forum/admin";
    }


}
