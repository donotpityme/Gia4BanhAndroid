package com.example.administrator.gia4banh;

public class Product {
    public int Id;
    public String Name;
    public int Price;
    public int Sochongoi;

    public Product() {
    }

    public Product(int id, String name, int price, int sochongoi) {
        Id = id;
        Name = name;
        Price = price;
        Sochongoi = sochongoi;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getSochongoi() {
        return Sochongoi;
    }

    public void setSochongoi(int sochongoi) {
        Sochongoi = sochongoi;
    }
}
