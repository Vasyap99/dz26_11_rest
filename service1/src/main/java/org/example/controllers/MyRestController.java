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


import org.example.util.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import org.example.service.*;


@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    MyRestService s;

    @GetMapping("/news")
    public Page news(Model model) {
        try{
            return s.getNews();
        }catch(Exception e){throw new MyRestException();}
    }

    @GetMapping("/location")
    public Location location(Model model) {
        return s.getLocation();
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
