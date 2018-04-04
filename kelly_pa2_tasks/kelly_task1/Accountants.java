// Accountants class that extends the Employees since an Accountant is an Employee
public class Accountants extends Employees {

    // parking_allowance variable creation
    double parking_allowance;

    // Allowance and name setting
    public Accountants(String name, double allowance) {
        this.parking_allowance = allowance;
        this.name = name;
    }

    // Override statement to report this class salary
    @Override
    public String reportSalary() {
        return " I'm an: accountant. I make " + df.format(this.salary) + " per year." + " My parking allowance is " + df.format(this.parking_allowance);
    }

    // Override statement for toString in Accountants class
    @Override
    public String toString() {
        return "My name is: " + this.name;
    }

    // Setter for Parking Allowance
    public void setParking_allowance(double parking_allowance1){
        this.parking_allowance = parking_allowance1;
    }

    // Getter for Parking Allowance
    public double getParking_allowance() {
        return this.parking_allowance;
    }
}
