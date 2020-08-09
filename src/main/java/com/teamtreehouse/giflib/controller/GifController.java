package com.teamtreehouse.giflib.controller;

import com.teamtreehouse.giflib.data.GifRepository;
import com.teamtreehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/gifs")
    public List<Gif> listGifs() {
        List<Gif> allGifs = gifRepository.getAllGifs();
        return allGifs;
    }

    @RequestMapping("/gifs/{name}")
    public Gif gifDetails(@PathVariable String name) {
        Gif gif = gifRepository.findByName(name);
        return gif;
    }
}
