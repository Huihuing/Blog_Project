package com.example.Blog_Project.Blog.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "category_list";
    }

    @GetMapping("/categories/{id}")
    public String viewCategory(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id)));
        return "category_detail";
    }

    @GetMapping("/categories/create")
    public String showCreateForm(@RequestParam("redirectUrl") String redirectUrl, Model model) {
        model.addAttribute("redirectUrl", redirectUrl);
        return "category_create_form";
    }

    @PostMapping("/categories/create")
    public String createCategory(@RequestParam("name") String name, @RequestParam("redirectUrl") String redirectUrl) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        return "redirect:" + redirectUrl;
    }
}
