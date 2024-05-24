package com.example.Blog_Project.Blog;

import com.example.Blog_Project.Blog.log.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final LogService logService;

    public MainController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("logs", logService.getAllLogs());
        return "log_list";
    }
}
