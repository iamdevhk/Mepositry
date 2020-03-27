package com.example.mepositry;



public class Product {
    public int id;
    public String con;
    private String desc;


    public Product(int id, String con, String desc) {
        this.id = id;
        this.con = con;
        this.desc = desc;

    }

    public int getId() {
        return id;
    }

    public String getCon() {
        return con;
    }

    public String getDesc() {
        return desc;
    }


}

