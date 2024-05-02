package com.example.Blog_Project.Blog.log;

import com.example.Blog_Project.Blog.category.Category;
import com.example.Blog_Project.Blog.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class LogController {

    private final CategoryRepository categoryRepository;
    private final LogRepository logRepository;
    private final LogService logService;

    @GetMapping("/write")
    public String showWriteForm() {
        // 등록 폼을 보여주는 코드
        return "log_write_form"; // 예시로 "write_form"을 리턴하도록 가정
    }

    @PostMapping("/write")
    public String writeLog(@RequestParam("title") String title, @RequestParam("content") String content) {
        Log log = new Log();
        log.setTitle(title);
        log.setContent(content);
        log.setPresentTime(LocalDateTime.now());
        logRepository.save(log);
        return "redirect:/"; // 저장 후 메인 페이지로 리다이렉트
    }
}
