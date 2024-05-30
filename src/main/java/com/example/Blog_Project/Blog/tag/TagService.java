package com.example.Blog_Project.Blog.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    public Tag createTag(String name) {
        Tag tag = new Tag();
        tag.setName(name);
        return tagRepository.save(tag);
    }

    public Tag getTag(Long id) {
        return tagRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid tag Id:" + id));
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

}
