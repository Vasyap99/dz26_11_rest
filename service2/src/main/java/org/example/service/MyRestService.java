package org.example.service;

import org.springframework.stereotype.Service;
import org.example.dto.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.example.dto.*;
import org.example.repo.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;


@Service
public class MyRestService{
    @Autowired 
    NewsRepository repo;
    public Page getNews() {
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