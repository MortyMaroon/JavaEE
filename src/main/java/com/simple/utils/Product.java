package com.simple.utils;

public class Product {
    private int id;
    private String title;
    private int cost;

    public Product(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("Product{ id = %d, title = %s, cost = %d}", id, title, cost);
    }
}