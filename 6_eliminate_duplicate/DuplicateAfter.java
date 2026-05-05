class CalculationService {

    public double calculateTotal(double subtotal, double taxRate) {
        double tax = subtotal * taxRate;
        return subtotal + tax;
    }

    public double applyDiscount(double total, double discountRate) {
        return total * (1 - discountRate);
    }
}

class OrderCalculatorAfter {
    private final CalculationService calculationService;

    public OrderCalculatorAfter(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    public double calculateOrderTotal(double subtotal, double taxRate) {
        return calculationService.calculateTotal(subtotal, taxRate);
    }

    public double applyOrderDiscount(double total, double discountRate) {
        return calculationService.applyDiscount(total, discountRate);
    }
}

class DiscountCalculatorAfter {
    private final CalculationService calculationService;

    public DiscountCalculatorAfter(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    public double calculateDiscountedTotal(double subtotal, double taxRate, double discountRate) {
        double total = calculationService.calculateTotal(subtotal, taxRate);
        return calculationService.applyDiscount(total, discountRate);
    }
}

class MainDuplicateAfter {
    public static void main(String[] args) {
        CalculationService calculationService = new CalculationService();

        OrderCalculatorAfter    orderCalc    = new OrderCalculatorAfter(calculationService);
        DiscountCalculatorAfter discountCalc = new DiscountCalculatorAfter(calculationService);

        double orderTotal     = orderCalc.calculateOrderTotal(100.0, 0.1);      
        double discountedTotal = discountCalc.calculateDiscountedTotal(100.0, 0.1, 0.2); 

        System.out.println("Order Total:      " + orderTotal);     
        System.out.println("Discounted Total: " + discountedTotal); 
    }
}