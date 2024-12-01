package org.example.dto;

import java.util.List;


public class Page{
    public Page(){}
    public Page(List<News> ns,Weather w){
        this.ns=ns;
        this.w=w;
    }
    public List<News> ns;
    public Weather w;
    public void setNs(List<News> ns){
        this.ns=ns;
    }
    public void setWeather(Weather w){
        this.w=w;
    }
}