
class Customer {
    private boolean premium;
    public Customer(boolean premium) { this.premium = premium; }
    public boolean isPremium() { return premium; }
}

class Order {
    private double   totalAmount;
    private Customer customer;
    public Order(double totalAmount, boolean isPremium) {
        this.totalAmount = totalAmount;
        this.customer    = new Customer(isPremium);
    }
    public double   getTotalAmount() { return totalAmount; }
    public Customer getCustomer()    { return customer; }
}

public class DiscountCalculatorBefore {

        public double calculateDiscount(Order order) {
        double discount = 0.0;

        if (order.getTotalAmount() > 100) {           
            if (order.getCustomer().isPremium()) {    
                discount = 0.2; 
                } else {
                discount = 0.1; 
            }
        }
        
        return discount;
    }

    public static void main(String[] args) {
        DiscountCalculatorBefore calc = new DiscountCalculatorBefore();

        Order smallOrder   = new Order(50,  true);
        Order regularOrder = new Order(150, false);
        Order premiumOrder = new Order(150, true);

        System.out.println("Small order discount:   " + calc.calculateDiscount(smallOrder));   // 0.0
        System.out.println("Regular order discount: " + calc.calculateDiscount(regularOrder)); // 0.1
        System.out.println("Premium order discount: " + calc.calculateDiscount(premiumOrder)); // 0.2
    }
}