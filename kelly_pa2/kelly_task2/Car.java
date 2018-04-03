// Car class that implements Driveable class
public class Car implements Driveable, Comparable<Car> {

    // Variable creation
    String make;
    String model;
    int year;
    int odometerReading;

    // Car class to define make, model, and year
    public Car(String make, String model, int year, int odometerReading) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.odometerReading = odometerReading;
    }

    // Overrides default drive to be specific to this class
    @Override
    public void drive(double drivenMiles) {
        this.odometerReading += drivenMiles;

    }

    // toString method to print out the cars and their mileage
    public String toString() {
        return this.year + " " + this.make + " " + this.model + " " + "with " + this.odometerReading + " miles";
    }

    // Sets the make to n
    public void setMake(String n) {
        this.make = n;

    }

    // Sets the model to n
    public void setModel(String n) {
        this.model = n;
    }

    // Sets the year to n
    public void setYear(int n) {
        this.year = n;
    }

    // Sets the Odometer
    public void setOdometerReading(int odometer) {
        this.odometerReading = odometer;
    }

    // Gathers odometer reading
    public int getOdometerReading(){
        return this.odometerReading;
    }

    // Gathers the make
    public String getMake(){
        return this.make;
    }

    // Gathers the model
    public String getModel(){
        return this.model;
    }

    // Gathers the year
    public int getYear(){
        return this.year;
    }

    // Noted that this was needed in the directions - but I don't use it
    // because I implement my own sort. Not sure if I used this correctly.
    @Override
    public int compareTo(Car n) {
        if(this.odometerReading == n.odometerReading)
            return 0;
        else if(this.odometerReading > n.odometerReading)
            return 1;
        else
            return -1;
    }

}