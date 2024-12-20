// Base Class: Employee
class Employee {
    privente int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public void work() {
        System.out.println(name + " is working in the " + department + " department.");
    }

    public void takeBreak() {
        System.out.println(name + " is taking a break.");
    }

    public double calculateSalary() {
        System.out.println("Base salary calculation for " + name);
        return 0.0;
    }
}

// Subclass: Manager
class Manager extends Employee {
    private int teamSize;
    private double bonus;

    public Manager(int id, String name, String department, int teamSize, double bonus) {
        super(id, name, department);
        this.teamSize = teamSize;
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println(name + " is managing a team of " + teamSize + " members.");
    }

    @Override
    public double calculateSalary() {
        double baseSalary = 5000; // Example base salary
        return baseSalary + bonus;
    }
}

// Subclass: Developer
class Developer extends Employee {
    private String programmingLanguage;

    public Developer(int id, String name, String department, String programmingLanguage) {
        super(id, name, department);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void work() {
        System.out.println(name + " is coding in " + programmingLanguage + ".");
    }

    @Override
    public double calculateSalary() {
        double baseSalary = 4000; // Example base salary
        return baseSalary;
    }
}

// Subclass: Intern
class Intern extends Employee {
    private int duration; // in months

    public Intern(int id, String name, String department, int duration) {
        super(id, name, department);
        this.duration = duration;
    }

    @Override
    public void work() {
        System.out.println(name + " is undergoing training for " + duration + " months.");
    }

    @Override
    public void takeBreak() {
        System.out.println(name + " is taking a restricted break as an intern.");
    }

    @Override
    public double calculateSalary() {
        double stipend = 1000; // Example stipend
        return stipend;
    }
}

// Subclass: Contractor
class Contractor extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public Contractor(int id, String name, String department, double hourlyRate, int hoursWorked) {
        super(id, name, department);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void work() {
        System.out.println(name + " is working as a contractor in the " + department + " department.");
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

// Main Class
public class CompanyHierarchy {
    public static void main(String[] args) {
        // Creating instances of each type of employee
        Employee manager = new Manager(1, "Alice", "HR", 5, 2000);
        Employee developer = new Developer(2, "Bob", "IT", "Java");
        Employee intern = new Intern(3, "Charlie", "Finance", 6);
        Employee contractor = new Contractor(4, "Diana", "Operations", 50, 160);

        // Using polymorphism to handle work and salary calculations
        Employee[] employees = {manager, developer, intern, contractor};

        for (Employee emp : employees) {
            emp.work();
            System.out.println(emp.name + "'s salary: " + emp.calculateSalary());
            emp.takeBreak();
            System.out.println();
        }
    }
}
