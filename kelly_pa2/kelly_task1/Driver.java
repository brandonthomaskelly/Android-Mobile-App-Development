/**
 * This program goes through employee data and prints their information based on what is below as well as what
 * is defined in their respective classes.
 * CPSC 312-01, Fall 2017
 * PA2
 * No sources to cite.
 *
 * @author Brandon Kelly
 * @version v0.1 9/26/17
 */

import java.util.ArrayList; // Array usage
import java.util.List; // List usage

// Driver class that supplies the employee list/information and prints them
public class Driver {
    // Supplies employee information
    public static void main(String[] args) {
        List<Employees> employeesList = new ArrayList<Employees>();
        employeesList.add(new Programmers("Brandon Kelly", false));
        employeesList.add(new Programmers("Ima Nerd", true));
        employeesList.add(new Lawyers("Kenny Dewitt", 10));
        employeesList.add(new Lawyers("Dan. D Lyon", 0));
        employeesList.add(new Lawyers("Willie Makit", 100));
        employeesList.add(new Accountants("Hal E. Luya", 17.00));
        employeesList.add(new Accountants("Midas Well", 45.50));
        employeesList.add(new Accountants("Doll R. Bill", 2.50));

        // Goes through the employees and prints their information according to what is above and their class
        for (Employees e : employeesList) {
            System.out.println(e.toString());
            System.out.println(e.reportSalary());
        }
    }
}
