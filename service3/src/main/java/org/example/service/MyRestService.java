package org.example.service;

import org.springframework.stereotype.Service;
import org.example.dto.*;
import org.springframework.web.client.RestTemplate;

@Service
public class MyRestService{
    public Weather getWeather(Location location) {
        //(определяем прогноз погоды по местоположению)
        return new Weather("Пасмурно, небольшой дождь",(short)3,(short)767,(byte)96);        
    }
}