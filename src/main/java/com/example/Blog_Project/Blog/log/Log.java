package com.example.Blog_Project.Blog.log;

import com.example.Blog_Project.Blog.category.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime presentTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}
