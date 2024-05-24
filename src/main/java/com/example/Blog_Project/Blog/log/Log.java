package com.example.Blog_Project.Blog.log;

import com.example.Blog_Project.Blog.category.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime presentTime;

    @PrePersist
    protected void onCreate() {
        this.presentTime = LocalDateTime.now();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}
