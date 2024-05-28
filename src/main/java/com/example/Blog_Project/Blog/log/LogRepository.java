package com.example.Blog_Project.Blog.log;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findByTitleContainingOrContentContaining(String title, String content);
}
