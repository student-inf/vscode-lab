package com.lab;

import java.util.List;
import java.util.ArrayList;


class Customer {
    private String  name;
    private boolean isMember;

    public Customer(String name, boolean isMember) {
        this.name     = name;
        this.isMember = isMember;
    }

    public String  getName()    { return name; }
    public boolean isMember()   { return isMember; }
}

class Item {
    private String name;
    private double price;
    private int    quantity;

    public Item(String name, double price, int quantity) {
        this.name     = name;
        this.price    = price;
        this.quantity = quantity;
    }

    public String getName()     { return name; }
    public double getPrice()    { return price; }
    public int    getQuantity() { return quantity; }
}

class Order {
    private Customer    customer;
    private List<Item>  items;

    public Order(Customer customer) {
        this.customer = customer;
        this.items    = new ArrayList<>();
    }

    public void addItem(Item item)      { items.add(item); }
    public Customer   getCustomer()     { return customer; }
    public List<Item> getItems()        { return items; }
}