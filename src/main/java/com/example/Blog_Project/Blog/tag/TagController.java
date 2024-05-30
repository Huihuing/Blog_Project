package com.example.Blog_Project.Blog.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping("/tags")
    public String listTags(Model model) {
        model.addAttribute("tags", tagService.getAllTags());
        return "tag_list";
    }

    @GetMapping("/tags/create")
    public String showCreateForm(@RequestParam("redirectUrl") String redirectUrl, Model model) {
        model.addAttribute("redirectUrl", redirectUrl);
        return "tag_create_form";
    }

    @PostMapping("/tags/create")
    public String createTag(@RequestParam("name") String name, @RequestParam("redirectUrl") String redirectUrl) {
        tagService.createTag(name);
        return "redirect:" + redirectUrl;
    }
}
