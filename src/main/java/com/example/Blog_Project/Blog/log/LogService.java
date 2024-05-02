package com.example.Blog_Project.Blog.log;

import com.example.Blog_Project.Blog.category.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

//    public Log saveDefault() {
//        Log log = new Log();
//        log.setTitle("asdf");
//        log.setContent("");
//        log.setPresentTime(LocalDateTime.now());
//        return logRepository.save(log);
//    }
}
