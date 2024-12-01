package org.example.dto;

public class Weather{
    public Weather(){}
    public Weather(String d,short t,short p,byte h){
        this.d=d;
        this.t=t;
        this.p=p;
        this.h=h;
    }
    public String d=""; //описание
    public short t; //температура
    public short p; //давление
    public byte h; //влажность
}