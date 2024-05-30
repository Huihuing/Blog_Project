package com.example.Blog_Project.Blog.log;

import com.example.Blog_Project.Blog.category.Category;
import com.example.Blog_Project.Blog.category.CategoryRepository;
import com.example.Blog_Project.Blog.tag.Tag;
import com.example.Blog_Project.Blog.tag.TagRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class LogController {

    private static final Logger log = LoggerFactory.getLogger(LogController.class);
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;
    private final LogRepository logRepository;
    private final LogService logService;

    @GetMapping("/logs")
    public String listLogs(Model model) {
        List<Log> logs = logRepository.findAll();
        model.addAttribute("logs", logs);
        return "log_list";
    }

    @GetMapping("/logs/{id}")
    public String viewLog(@PathVariable Long id, Model model) {
        Log log = logRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid log Id:" + id));
        model.addAttribute("log", log);
        return "log_detail";
    }

    @GetMapping("/write")
    public String showWriteForm(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        return "log_write_form";
    }

    @PostMapping("/write")
    public String logWrite(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("categoryId") Long categoryId, @RequestParam("tagIds") List<Long> tagIds) {
        Log log = new Log();
        log.setTitle(title);
        log.setContent(content);
        log.setPresentTime(LocalDateTime.now());
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + categoryId));
        log.setCategory(category);
        Set<Tag> tags = tagIds.stream()
                .map(tagId -> tagRepository.findById(tagId).orElseThrow(() -> new IllegalArgumentException("Invalid tag Id:" + tagId)))
                .collect(Collectors.toSet());
        log.setTags(tags);
        logRepository.save(log);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String detail() {
        return "log_detail";
    }

    @GetMapping("/logs/update/{id}")
    public String updateLog(@PathVariable("id") Long id, Model model) {
        Log log = logService.getLog(id);
        model.addAttribute("log", log);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        return "log_update_form";
    }

    @PostMapping("/logs/update/{id}")
    public String updateLog(@PathVariable("id") Long id, @ModelAttribute LogForm logForm, @RequestParam("categoryId") Long categoryId, @RequestParam("tagIds") List<Long> tagIds) {
        Log log = logService.getLog(id);
        log.setTitle(logForm.getTitle());
        log.setContent(logForm.getContent());
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + categoryId));
        log.setCategory(category);
        Set<Tag> tags = tagIds.stream()
                .map(tagId -> tagRepository.findById(tagId).orElseThrow(() -> new IllegalArgumentException("Invalid tag Id:" + tagId)))
                .collect(Collectors.toSet());
        log.setTags(tags);
        logService.save(log);
        return "redirect:/";
    }

    @GetMapping("/logs/delete/{id}")
    public String deleteLog(@PathVariable("id") Long id) {
        logService.delete(id);
        return "redirect:/";
    }
}
