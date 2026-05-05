
class CustomerA {
    private boolean premium;
    public CustomerA(boolean premium) { this.premium = premium; }
    public boolean isPremium() { return premium; }
}

class OrderA {
    private double    totalAmount;
    private CustomerA customer;
    public OrderA(double totalAmount, boolean isPremium) {
        this.totalAmount = totalAmount;
        this.customer    = new CustomerA(isPremium);
    }
    public double    getTotalAmount() { return totalAmount; }
    public CustomerA getCustomer()    { return customer; }
}

public class DiscountCalculatorAfter {

    
    public double calculateDiscount(OrderA order) {

        if (order.getTotalAmount() <= 100) {
            return 0.0;
        }

        if (order.getCustomer().isPremium()) {
            return 0.2; 
        }

        return 0.1;
    }

    public static void main(String[] args) {
        DiscountCalculatorAfter calc = new DiscountCalculatorAfter();

        OrderA smallOrder   = new OrderA(50,  true);
        OrderA regularOrder = new OrderA(150, false);
        OrderA premiumOrder = new OrderA(150, true);

        System.out.println("Small order discount:   " + calc.calculateDiscount(smallOrder));   // 0.0
        System.out.println("Regular order discount: " + calc.calculateDiscount(regularOrder)); // 0.1
        System.out.println("Premium order discount: " + calc.calculateDiscount(premiumOrder)); // 0.2
    }
}