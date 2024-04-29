package com.example.Blog_Project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class test {

    @GetMapping("/asdf")
    public String main() {

        return "MainForm";
    }
}
