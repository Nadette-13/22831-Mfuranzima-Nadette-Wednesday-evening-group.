// Payable Interface
interface Payable {
    double calculateSalary();
    String getPaySlip();
}

// Abstract Employee class implementing Payable
abstract class Employee implements Payable {
    private String name;
    private String employeeId;
    private double baseSalary;

    // Constructor
    public Employee(String name, String employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }

    // Getter and Setter for encapsulation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}

// Manager class extending Employee
class Manager extends Employee {
    private int teamSize;
    private static final double BONUS_PER_TEAM_MEMBER = 500;

    // Constructor
    public Manager(String name, String employeeId, double baseSalary, int teamSize) {
        super(name, employeeId, baseSalary);
        this.teamSize = teamSize;
    }

    // Calculate salary for Manager (Base salary + Bonus)
    @Override
    public double calculateSalary() {
        return getBaseSalary() + (teamSize * BONUS_PER_TEAM_MEMBER);
    }

    // Generate pay slip for Manager
    @Override
    public String getPaySlip() {
        return "Manager: " + getName() + "\nEmployee ID: " + getEmployeeId() + "\nBase Salary: $" + getBaseSalary() + 
               "\nTeam Size: " + teamSize + "\nTotal Salary: $" + calculateSalary();
    }
}

// Developer class extending Employee
class Developer extends Employee {
    private int projectsCompleted;
    private static final double BONUS_PER_PROJECT = 300;

    // Constructor
    public Developer(String name, String employeeId, double baseSalary, int projectsCompleted) {
        super(name, employeeId, baseSalary);
        this.projectsCompleted = projectsCompleted;
    }

    // Calculate salary for Developer (Base salary + Bonus)
    @Override
    public double calculateSalary() {
        return getBaseSalary() + (projectsCompleted * BONUS_PER_PROJECT);
    }

    // Generate pay slip for Developer
    @Override
    public String getPaySlip() {
        return "Developer: " + getName() + "\nEmployee ID: " + getEmployeeId() + "\nBase Salary: $" + getBaseSalary() + 
               "\nProjects Completed: " + projectsCompleted + "\nTotal Salary: $" + calculateSalary();
    }
}

// Main Class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Create Manager instance
        Manager manager = new Manager("Alice Johnson", "M001", 5000, 5);

        // Create Developer instance
        Developer developer = new Developer("Bob Smith", "D001", 4000, 3);

        // Print pay slips
        System.out.println(manager.getPaySlip());
        System.out.println("\n---------------------------\n");
        System.out.println(developer.getPaySlip());
    }
}
