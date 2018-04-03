/**
 * This program simulates driving different cars.
 * CPSC 312-01, Fall 2017
 * PA2 Task 2
 * No sources to cite.
 *
 * @author Brandon Kelly
 * @version v0.1 9/26/17
 */

// Necessary imports
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Driver {

    // Performs insertion sort on the car list
    public static void sortAlgr(List<Car> list){
        int n, m;
        // Traverses the list
        for (n = 1; n < list.size(); n++) {

            Car temp = list.get(n);

            m = n;

            while (m > 0 && (list.get(m - 1).getOdometerReading() > temp.getOdometerReading())) {
                list.set(m, list.get(m - 1));
                m--;
            }

            list.set(m, temp);
        }
    }

    // Main method that drives the program
    public static void main(String[] args) {
        Random rand = new Random(); // Simulates random numbers

        // Car listings
        List<Car> car_listing = new ArrayList<Car>();
        car_listing.add(new Car("Acura", "Integra", 1992, rand.nextInt(300000) + 1));
        car_listing.add(new Car("Subaru", "Outback", 1998, rand.nextInt(300000) + 1));
        car_listing.add(new Car("Ford", "Raptor", 2010, rand.nextInt(300000) + 1));
        car_listing.add(new Car("BMW", "M5", 2003, rand.nextInt(300000) + 1));
        car_listing.add(new Car("Audi", "R8", 2009, rand.nextInt(300000) + 1));
        car_listing.add(new Car("Chevrolet", "Cavalier", 2001, rand.nextInt(300000) + 1));
        car_listing.add(new Car("Bugatti", "Veyron", 2009, rand.nextInt(300000) + 1));
        car_listing.add(new Car("Ford", "F150", 2013, rand.nextInt(300000) + 1));
        car_listing.add(new Car("Nissan", "RX8", 2002, rand.nextInt(300000) + 1));
        car_listing.add(new Car("Nissan", "180SX", 1995, rand.nextInt(300000) + 1));
        // Insertion sort
        sortAlgr(car_listing);

        System.out.println("");
        System.out.println("CARS HAVE NOT BEEN DRIVEN:");

        // "Drives" the cars
        for (Car car : car_listing) {
            System.out.println(car.toString());
            if(Math.random() < 0.5)
                car.drive(rand.nextInt(100000) + 15000);
        }

        System.out.println("");
        System.out.println("CARS HAVE BEEN DRIVEN:");

        // Insertion sort after "driving"
        for (Car car : car_listing)
            System.out.println(car.toString());

        sortAlgr(car_listing);

        System.out.println("");
        System.out.println("INSERTION SORT PERFORMED:");

        // Final printing of ordered list
        for (Car car : car_listing)
            System.out.println(car.toString());

    }
}