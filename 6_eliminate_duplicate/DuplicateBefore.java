class OrderCalculatorBefore {

    public double calculateTotal(double subtotal, double taxRate) {
        double tax = subtotal * taxRate;
        return subtotal + tax;
    }

    public double applyDiscount(double total, double discountRate) {
        return total * (1 - discountRate);
    }
}

class DiscountCalculatorBefore {

        public double calculateTotal(double subtotal, double taxRate) {
        double tax = subtotal * taxRate;
        return subtotal + tax;
    }

    public double applyDiscount(double total, double discountRate) {
        return total * (1 - discountRate);
    }
}

class MainDuplicateBefore {
    public static void main(String[] args) {
        OrderCalculatorBefore    oc = new OrderCalculatorBefore();
        DiscountCalculatorBefore dc = new DiscountCalculatorBefore();

        double orderTotal     = oc.calculateTotal(100.0, 0.1);
        double discountedTotal = dc.applyDiscount(
                                    dc.calculateTotal(100.0, 0.1), 0.2);

        System.out.println("Order Total:      " + orderTotal);      
        System.out.println("Discounted Total: " + discountedTotal); 
    }
}