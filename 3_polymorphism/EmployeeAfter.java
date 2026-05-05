abstract class Employee {
    abstract double calculateBonus();

    public void printBonus() {
        System.out.println(getClass().getSimpleName()
            + " bonus: $" + calculateBonus());
    }
}

class Manager extends Employee {
    @Override
    double calculateBonus() { return 5000; }
}

class Developer extends Employee {
    @Override
    double calculateBonus() { return 3000; }
}

class Intern extends Employee {
    @Override
    double calculateBonus() { return 1000; }
}

class TeamLead extends Employee {
    @Override
    double calculateBonus() { return 4000; }
}

class MainPolymorphism {
    public static void main(String[] args) {
        Employee[] employees = {
            new Manager(),
            new Developer(),
            new Intern(),
            new TeamLead()  
        };

        for (Employee emp : employees) {
            emp.printBonus();
        }
    }
}