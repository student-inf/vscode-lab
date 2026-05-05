package com.lab;

import java.util.List;


public class OrderProcessor {

    public void printOrderSummary(Order order) {
        double totalPrice = calculateTotalPrice(order.getItems());
        totalPrice = applyDiscount(totalPrice, order.getCustomer().isMember());
        printSummary(order, totalPrice);
    }

    public double calculateTotalPrice(List<Item> items) {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public double applyDiscount(double totalPrice, boolean isMember) {
        if (isMember) {
            return totalPrice * 0.9; 
        }
        return totalPrice;
    }

    private void printSummary(Order order, double totalPrice) {
        System.out.println("Order Summary:");
        System.out.println("Customer: " + order.getCustomer().getName());
        printItems(order.getItems());
        System.out.printf("Total Price: $%.2f%n", totalPrice);
    }

    private void printItems(List<Item> items) {
        System.out.println("Items:");
        for (Item item : items) {
            System.out.println("  - " + item.getName() + ": "
                + item.getQuantity() + " x $" + item.getPrice()
                + " = $" + (item.getQuantity() * item.getPrice()));
        }
    }
}