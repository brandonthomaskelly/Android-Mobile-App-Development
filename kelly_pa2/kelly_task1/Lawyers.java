// Lawyer class that extends Employees since a Lawyer is an Employee
public class Lawyers extends Employees {
    int stocks; // Stocks variable creation

    // Sets name, salary, and stocks specific to Lawyer class
    public Lawyers(String name, int stocks) {
        this.name = name;
        this.salary = salary + 30000;
        this.stocks = stocks;
    }

    // Overrides default toString so it prints names specific to Lawyers
    @Override
    public String toString() {
        return "My name is: " + this.name;
    }

    // Overrides reportSalary so that it prints salaries specific to Lawyers
    @Override
    public String reportSalary() {
        return " I'm a: lawyer. I make " + df.format(this.salary) + " a year. I get " + this.stocks + " in stocks.";
    }

    // Setter for stocks
    public void setterStocks(int n) {
        this.stocks = n;
    }

    // Getter for stocks
    public int getStocks() {
        return this.stocks;
    }

}
