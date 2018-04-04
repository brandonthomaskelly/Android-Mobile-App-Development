import java.text.DecimalFormat; // Necessary for decimal format (df) usage

// Employee class
abstract public class Employees {

    // Variable declarations as well as setting the df format
    String name;
    double salary = 40000.00; // base salary for all employee
    DecimalFormat df = new DecimalFormat("0.00");

    public abstract String reportSalary();  // default reportSalary

    // Overrides toString to print that someone is an employee
    @Override
    public String toString() {
        return "I'm an: employee.";
    }

    // Name setter for employees
    public void setName(String name1) {
        this.name = name1;
    }

    // Name getter for employees
    public String getName() {
        return this.name;
    }

    // Salary setter for employees
    public void setSalary(double salary1) {
        this.salary = salary1;
    }

    // Salayer getter for employees
    public double getSalary() {
        return this.salary;
    }
}
