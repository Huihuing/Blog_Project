package com.example.Blog_Project.Blog;

import com.example.Blog_Project.Blog.category.CategoryRepository;
import com.example.Blog_Project.Blog.log.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final CategoryRepository categoryRepository;
    private final LogRepository logRepository;

    @RequestMapping("/")
    public String Main(Model model) {

        return "MainForm";
    }


}

//@Controller
//@RequiredArgsConstructor
//public class test {
//
//    @GetMapping("/asdf")
//    public String main() {
//
//        return "MainForm";
//    }
//}