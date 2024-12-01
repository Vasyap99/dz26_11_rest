package org.example.controllers;

//import org.example.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.example.dto.*;
import org.example.repo.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;


@RestController
public class MyRestController {
    @Autowired 
    NewsRepository repo;

    @GetMapping("/api/news")
    public Page news(Model model) {
        List<org.example.models.News> l0=repo.findAll();
        List<News> l=l0.stream().map(e -> new News(e.getHeader(),e.getInfo()) ).collect(Collectors.toList());
        // 
        Location location=new RestTemplate().getForObject("http://127.0.0.1:8200/api/location",Location.class);
        //
        HttpEntity<Location> request = new HttpEntity<>(location);
        Weather w=new RestTemplate().postForObject("http://127.0.0.1:8202/api/weather", request, Weather.class);
        Page p=new Page(l,w);
        return p;
    }
}
