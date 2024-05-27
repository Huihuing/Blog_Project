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

    public List<Log> findAll() {
        return logRepository.findAll();
    }

    public Log findById(Long id) {
        return logRepository.findById(id).orElseThrow(() -> new RuntimeException("Log not found"));
    }

    public void save(LogForm logForm) {
        Log log = new Log();
        log.setTitle(logForm.getTitle());
        log.setContent(logForm.getContent());
        logRepository.save(log);
    }

    public void update(Long id, LogForm logForm) {
        Log log = logRepository.findById(id).orElseThrow(() -> new RuntimeException("Log not found"));
        log.setTitle(logForm.getTitle());
        log.setContent(logForm.getContent());
        logRepository.save(log);
    }

    public void delete(Long id) {
        logRepository.deleteById(id);
    }

    public Log getLog(Long id) {
        return logRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid log Id:" + id));
    }

    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }
}
