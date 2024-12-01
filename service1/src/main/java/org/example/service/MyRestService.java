package org.example.service;

import org.springframework.stereotype.Service;
import org.example.dto.*;
import org.springframework.web.client.RestTemplate;

@Service
public class MyRestService{
    public Page getNews(){
        Page p=new RestTemplate().getForObject("http://127.0.0.1:8201/api/news",Page.class);;
        return p;
    }
    public Location getLocation(){
        return new Location("Великий Новгород");
    }
}