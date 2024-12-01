package org.example.controllers;

//import org.example.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

/*import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Arrays;*/

import org.example.dto.*;

import org.springframework.web.client.RestTemplate;

import org.example.util.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api")
public class MyRestController {

    @GetMapping("/news")
    public Page news(Model model) {
        try{
            Page p=new RestTemplate().getForObject("http://127.0.0.1:8201/api/news",Page.class);;
            return p;
        }catch(Exception e){throw new MyRestException();}
    }

    @GetMapping("/location")
    public Location location(Model model) {
        return new Location("Великий Новгород");
    }
    @ExceptionHandler({MyRestException.class})
    private ResponseEntity<MyErrorResponse> handleException(MyRestException s){
        System.out.println(">>0");
        MyErrorResponse r=new MyErrorResponse("MyError");
        System.out.println(">>1");
        ResponseEntity<MyErrorResponse> re=new ResponseEntity<>(r,HttpStatus.NOT_FOUND);
        System.out.println(">>2");
        return re;
    }
}
