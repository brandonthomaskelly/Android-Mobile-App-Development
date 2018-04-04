// Programmers class that extends Employee since a Programmer is an Employee
public class Programmers extends Employees {
    boolean bus_pass = false;

    // Salary, name, and bus pass creation with name being a string and bus_pass a boolean
    public Programmers(String name, boolean bus_pass) {
        this.name = name;
        this.bus_pass = bus_pass;
        this.salary = salary + 20000.00;
    }

    // Override default toString to return names in this specific class
    @Override
    public String toString() {
        return "My name is: " + this.name;
    }

    // Override statement to report salary for Programmers class
    @Override
    public String reportSalary() {
        if (bus_pass) // Checks if the programmer has a bus pass or not
            return " I'm a: programmer. I make " + df.format(this.salary) + " a year. " + bus_pass + " I do get a bus pass.";
        return " I'm a: programmer. I make " + df.format(this.salary) + " a year." + bus_pass + " I do not get a bus pass.";
    }

}
