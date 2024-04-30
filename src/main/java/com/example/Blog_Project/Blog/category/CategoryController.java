package com.example.Blog_Project.Blog.category;

import com.example.Blog_Project.Blog.log.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final LogRepository logRepository;


}
