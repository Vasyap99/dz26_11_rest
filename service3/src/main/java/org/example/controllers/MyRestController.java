package org.example.controllers;

//import org.example.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.example.dto.*;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MyRestController {

    @PostMapping("/api/weather")
    public Weather weather(@RequestBody Location location) {
        //(определяем прогноз погоды по местоположению)
        return new Weather("Пасмурно, небольшой дождь",(short)3,(short)767,(byte)96);        
    }
}
