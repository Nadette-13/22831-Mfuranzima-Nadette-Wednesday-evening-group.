import java.util.ArrayList;
import java.util.List;

// Base Class: Person
class Person {
    private String name;
    private String email;
    private int age;

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Age: " + age);
    }
}

// Subclass: Employee
class Employee extends Person {
    private String employeeId;
    private double salary;
    private String department;

    public Employee(String name, String email, int age, String employeeId, double salary, String department) {
        super(name, email, age);
        this.employeeId = employeeId;
        this.salary = salary;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: $" + salary);
        System.out.println("Department: " + department);
    }
}

// Subclass: Manager
class Manager extends Employee {
    private List<Employee> subordinates;

    public Manager(String name, String email, int age, String employeeId, double salary, String department) {
        super(name, email, age, employeeId, salary, department);
        this.subordinates = new ArrayList<>();
    }

    public void addSubordinate(Employee subordinate) {
        subordinates.add(subordinate);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Subordinates: ");
        for (Employee subordinate : subordinates) {
            System.out.println(" - " + subordinate.getName());
        }
    }
}

// Subclass: CEO
class CEO extends Manager {
    private String responsibilities;

    public CEO(String name, String email, int age, String employeeId, double salary, String department, String responsibilities) {
        super(name, email, age, employeeId, salary, department);
        this.responsibilities = responsibilities;
    }

    @Override
    public void addSubordinate(Employee subordinate) {
        if (subordinate instanceof Manager) {
            super.addSubordinate(subordinate);
        } else {
            System.out.println("CEO can only add managers as subordinates.");
        }
    }

    public void generateReport() {
        System.out.println("Organization Report:");
        for (Employee manager : getSubordinates()) {
            manager.displayDetails();
            System.out.println();
        }
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Responsibilities: " + responsibilities);
    }
}

// Subclass: Client
class Client extends Person {
    private String companyName;
    private String address;

    public Client(String name, String email, int age, String companyName, String address) {
        super(name, email, age);
        this.companyName = companyName;
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Company Name: " + companyName);
        System.out.println("Address: " + address);
    }
}

// Main Class
public class OrganizationStructure {
    public static void main(String[] args) {
        // Create CEO
        CEO ceo = new CEO("Alice", "alice@company.com", 50, "CEO001", 200000, "Corporate", "Oversee the entire organization");

        // Create Managers
        Manager manager1 = new Manager("Bob", "bob@company.com", 40, "MGR001", 120000, "Sales");
        Manager manager2 = new Manager("Charlie", "charlie@company.com", 38, "MGR002", 110000, "IT");

        // Create Employees
        Employee emp1 = new Employee("David", "david@company.com", 30, "EMP001", 80000, "Sales");
        Employee emp2 = new Employee("Eve", "eve@company.com", 28, "EMP002", 75000, "IT");

        // Create Client
        Client client = new Client("Frank", "frank@client.com", 35, "ClientCorp", "123 Client St");

        // Build hierarchy
        ceo.addSubordinate(manager1);
        ceo.addSubordinate(manager2);
        manager1.addSubordinate(emp1);
        manager2.addSubordinate(emp2);

        // Display organization structure
        ceo.displayDetails();
        System.out.println();

        // Generate report
        ceo.generateReport();

        System.out.println("Client Details:");
        client.displayDetails();
    }
}
