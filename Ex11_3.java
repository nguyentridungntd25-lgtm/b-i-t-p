package ra.edu;

abstract class Employee {
    protected int id;
    protected String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public abstract double calculateSalary();
    public void showInfo() {
        System.out.println("ID: " + id + " - Name: " + name);
    }
}

interface BonusEligible {
    double calculateBonus();
}

class FullTimeEmployee extends Employee implements BonusEligible {
    private double baseSalary;

    public FullTimeEmployee(int id, String name, double baseSalary) {
        super(id, name);
        this.baseSalary = baseSalary;
    }
    @Override
    public double calculateSalary() {
        return baseSalary;
    }
    @Override
    public double calculateBonus() {
        return baseSalary * 0.1; // thưởng 10%
    }
}

class PartTimeEmployee extends Employee {
    private double workingHour;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, double workingHour, double hourlyRate) {
        super(id, name);
        this.workingHour = workingHour;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary() {
        return workingHour * hourlyRate;
    }
}

public class Ex11_3 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[2];
        employees[0] = new FullTimeEmployee(1, "An", 1000);
        employees[1] = new PartTimeEmployee(2, "Binh", 20, 10);
        for (Employee e : employees) {
            e.showInfo();
            double salary = e.calculateSalary();
            System.out.println("Lương: " + salary);

            if (e instanceof BonusEligible) {
                double bonus = ((BonusEligible) e).calculateBonus();
                System.out.println("Thưởng: " + bonus);
            }
        }
    }
}