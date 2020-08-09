package com.teamtreehouse.giflib.controller;

import com.teamtreehouse.giflib.data.CategoryRepository;
import com.teamtreehouse.giflib.data.GifRepository;
import com.teamtreehouse.giflib.model.Category;
import com.teamtreehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public List<Category> listCategories() {
        List<Category> categories = categoryRepository.getAllCategories();
        return categories;
    }

    @RequestMapping("/categories/{id}")
    public Category getCategory(@PathVariable int id) {
        Category category = categoryRepository.findById(id);
        return category;
    }

    @RequestMapping("/categories/{id}/gifs")
    public List<Gif> getCategoryGifs(@PathVariable int id) {
        List<Gif> gifs = gifRepository.findByCategoryId(id);
        return gifs;
    }
}
