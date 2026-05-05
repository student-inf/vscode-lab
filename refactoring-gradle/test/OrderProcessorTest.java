package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;


class OrderProcessorTest {

    private OrderProcessor processor;
    private Customer       memberCustomer;
    private Customer       regularCustomer;
    private Item           item1;
    private Item           item2;

    @BeforeEach
    void setUp() {
        processor       = new OrderProcessor();
        memberCustomer  = new Customer("Alice", true);
        regularCustomer = new Customer("Bob",   false);
        item1           = new Item("Book",  10.0, 2);  
        item2           = new Item("Pen",    5.0, 3);  
    }


    @Test
    void testCalculateTotalPrice_singleItem() {
        Order order = new Order(regularCustomer);
        order.addItem(item1); 
        double total = processor.calculateTotalPrice(order.getItems());
        assertEquals(20.0, total, 0.001);
    }

    @Test
    void testCalculateTotalPrice_multipleItems() {
        Order order = new Order(regularCustomer);
        order.addItem(item1); 
        order.addItem(item2); 
        double total = processor.calculateTotalPrice(order.getItems());
        assertEquals(35.0, total, 0.001);
    }

    @Test
    void testCalculateTotalPrice_emptyOrder() {
        Order order = new Order(regularCustomer);
        double total = processor.calculateTotalPrice(order.getItems());
        assertEquals(0.0, total, 0.001);
    }


    @Test
    void testApplyDiscount_memberGets10Percent() {
        double discounted = processor.applyDiscount(100.0, true);
        assertEquals(90.0, discounted, 0.001);
    }

    @Test
    void testApplyDiscount_nonMemberNoDiscount() {
        double discounted = processor.applyDiscount(100.0, false);
        assertEquals(100.0, discounted, 0.001);
    }

    @Test
    void testApplyDiscount_memberWithRealTotal() {
        double discounted = processor.applyDiscount(35.0, true);
        assertEquals(31.5, discounted, 0.001);
    }


    @Test
    void testFullOrder_memberDiscount() {
        Order order = new Order(memberCustomer);
        order.addItem(item1); 
        order.addItem(item2); 
        double total     = processor.calculateTotalPrice(order.getItems());
        double discounted = processor.applyDiscount(total, order.getCustomer().isMember());
        assertEquals(31.5, discounted, 0.001);
    }

    @Test
    void testFullOrder_regularNoDiscount() {
        Order order = new Order(regularCustomer);
        order.addItem(item1); 
        order.addItem(item2); 
        double total      = processor.calculateTotalPrice(order.getItems());
        double discounted = processor.applyDiscount(total, order.getCustomer().isMember());
        assertEquals(35.0, discounted, 0.001);
    }
}