public class PaymentProcessorBefore {

        public void processPayment(String paymentMethod, double amount) {
        if (paymentMethod.equals("CreditCard")) {
            System.out.println("Processing credit card payment of $" + amount);

        } else if (paymentMethod.equals("PayPal")) {
            System.out.println("Processing PayPal payment of $" + amount);

        } else if (paymentMethod.equals("Bitcoin")) {
            System.out.println("Processing Bitcoin payment of $" + amount);

        } else {
            throw new IllegalArgumentException("Unknown payment method: " + paymentMethod);
        }
    }

    public static void main(String[] args) {
        PaymentProcessorBefore processor = new PaymentProcessorBefore();
        processor.processPayment("CreditCard", 100.0);
        processor.processPayment("PayPal",     50.0);
        processor.processPayment("Bitcoin",    200.0);
    }
}