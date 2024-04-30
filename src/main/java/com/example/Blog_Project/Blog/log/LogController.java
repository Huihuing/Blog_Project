package com.example.Blog_Project.Blog.log;

import com.example.Blog_Project.Blog.category.Category;
import com.example.Blog_Project.Blog.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LogController {

    private final CategoryRepository categoryRepository;
    private final LogRepository logRepository;
    private final LogService logService;

    @PostMapping("/")
    public String write(@PathVariable("categoryId") Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();


        return "redirect:/";
    }
}
