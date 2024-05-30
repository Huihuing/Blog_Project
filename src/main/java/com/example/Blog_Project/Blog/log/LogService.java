package com.example.Blog_Project.Blog.log;

import com.example.Blog_Project.Blog.category.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    public Log saveDefault() {
        Log log = new Log();
        log.setTitle("Default Title");
        log.setContent("Default Content");
        log.setPresentTime(LocalDateTime.now());
        return logRepository.save(log);
    }


    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    public void save(Log log) {logRepository.save(log);}

    public void delete(Long id) {logRepository.deleteById(id);}

    public Log getLog(Long id) {
        return logRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid log Id:" + id));
    }
}
