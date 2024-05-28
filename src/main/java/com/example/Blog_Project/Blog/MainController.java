package com.example.Blog_Project.Blog;

import com.example.Blog_Project.Blog.log.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final LogService logService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("logs", logService.getAllLogs());
        return "log_list";
    }
}
