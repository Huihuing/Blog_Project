package com.example.Blog_Project.Blog.search;

import com.example.Blog_Project.Blog.log.Log;
import com.example.Blog_Project.Blog.log.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SearchController {

    private final LogRepository logRepository;

    @GetMapping("/logs/search")
    public String search(@RequestParam("query") String query, Model model) {
        List<Log> searchResults = logRepository.findByTitleContainingOrContentContaining(query, query);
        model.addAttribute("results", searchResults);
        return "Search_Result";
    }
}
