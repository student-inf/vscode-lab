public class CalculatorAfter {

    public double calculateSumProductRatio(double num1, double num2) {
        double sum     = num1 + num2;   
        double product = num1 * num2;    
        return sum / product;
    }

    
    public void printResult(double result) {
        System.out.println("Result: " + result);
    }

       public static void main(String[] args) {
        CalculatorAfter calc = new CalculatorAfter();
        double result = calc.calculateSumProductRatio(4, 2); 
        calc.printResult(result);
    }
}