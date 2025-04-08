import java.util.ArrayList;

public class PAssign05 {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Car car1 = new Car("Ford", "Expedition", 2020, 8);
        Car car2 = new Car("Toyota", "Camry", 2019, 5);
        Car car3 = new Car("Mazda", "MX5", 2018, 2);

        Truck truck1 = new Truck("Ford", "F-150", 2016, 10400.00);
        Truck truck2 = new Truck("Dodge", "Ram 1500", 2020, 7730.00);

        vehicles.add(car1);
        vehicles.add(car2);
        vehicles.add(car3);
        vehicles.add(truck1);
        vehicles.add(truck2);

        car1.addReview("Big, spacious, and handy, the Expedition is a workhorse but falls short of more appealing rivals.");
        car2.addReview("No review.");
        car3.addReview("A more characterful four-cylinder makes one of our favorites even better.");
        truck1.addReview("Turns out there is a replacement for displacement.");
        truck2.addReview("When only a pickup truck will do, the Ram 1500 is the one to choose.");

        System.out.println("All Vehicles:");
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%s\n\n", vehicle);
        }
    }
}

interface Reviewable {
    void addReview(String review);
}

abstract class Vehicle implements Reviewable {
    protected String make;
    protected String model;
    protected int year;
    protected String type;
    protected String review;

    public Vehicle() {
        this.make = "undefined";
        this.model = "undefined";
        this.year = 0;
        this.type = "undefined";
        this.review = "No review.";
    }

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = "undefined";
        this.review = "No review.";
    }

    @Override
    public void addReview(String review) {
        this.review = review;
    }

    public abstract String getDetailedInfo();

    @Override
    public String toString() {
        return getDetailedInfo();
    }

    public String getType() {
        return this.type;
    }

    public String getReview() {
        return this.review;
    }
}

class Car extends Vehicle {
    private int seatingCapacity;

    public Car() {
        super();
        this.type = "Car";
        this.seatingCapacity = 5;
    }

    public Car(String make, String model, int year, int seatingCapacity) {
        super(make, model, year);
        this.type = "Car";
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String getDetailedInfo() {
        return String.format("%d %s %s (Car)\nSeating Capacity: %d people\n%s",
                this.year, this.make, this.model, this.seatingCapacity, this.review);
    }

    public int getSeatingCapacity() {
        return this.seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
}

class Truck extends Vehicle {
    private double maxTowWeight;

    public Truck() {
        super();
        this.type = "Truck";
        this.maxTowWeight = 0.0;
    }

    public Truck(String make, String model, int year, double maxTowWeight) {
        super(make, model, year);
        this.type = "Truck";
        this.maxTowWeight = maxTowWeight;
    }

    @Override
    public String getDetailedInfo() {
        return String.format("%d %s %s (Truck)\nMax Tow Weight: %,10.2f lbs\n%s",
                this.year, this.make, this.model, this.maxTowWeight, this.review);
    }

    public double getMaxTowWeight() {
        return this.maxTowWeight;
    }

    public void setMaxTowWeight(double maxTowWeight) {
        this.maxTowWeight = maxTowWeight;
    }
}