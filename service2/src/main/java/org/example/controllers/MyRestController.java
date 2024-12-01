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
import org.example.service.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;


@RestController
public class MyRestController {
    @Autowired
    MyRestService s;

    @GetMapping("/api/news")
    public Page news(Model model) {
        return s.getNews();
    }
}
