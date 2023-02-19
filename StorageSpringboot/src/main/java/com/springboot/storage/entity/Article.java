package com.springboot.storage.entity;

import lombok.Data;
//实体类
@Data//为类提供读写功能，从而不用写get、set方法。
public class Article {

    private Integer id;
    private String num;
    private String name;
    private String price;
    private String weight;
    private String produce;
    private String save;
    private String date;
    private String recorder;


    public Article(Integer id, String num, String name, String price, String weight, String produce, String save, String date, String recorder) {
        this.id = id;
        this.num = num;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.produce = produce;
        this.save = save;
        this.date = date;
        this.recorder = recorder;
    }
}
