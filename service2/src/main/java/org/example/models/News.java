package org.example.models;

import javax.persistence.*;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int i;

    @Column
    String header;
    @Column
    String info;

    public News(){}
    public News(String header, String info) {
        this.header = header;
        this.info=info;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
