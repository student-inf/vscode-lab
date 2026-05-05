
public class EmployeeBefore {

    
    public double calculateBonus(String type) {
        if (type.equals("Manager")) {
            return 5000;
        } else if (type.equals("Developer")) {
            return 3000;
        } else if (type.equals("Intern")) {
            return 1000;
        } else {
            return 0; 
        }
    }

    public static void main(String[] args) {
        EmployeeBefore emp = new EmployeeBefore();
        System.out.println("Manager bonus:   $" + emp.calculateBonus("Manager"));
        System.out.println("Developer bonus: $" + emp.calculateBonus("Developer"));
        System.out.println("Intern bonus:    $" + emp.calculateBonus("Intern"));
    }
}