package projs;

public class Car {
    String model;
    String make;
    String color;
    String vin;

    // Default constructor
    public Car() {
        vin = "WSGJUW!#$";
    }

    // Parameterized constructor
    public Car(String mk, String mdl, String clr, String vn){
        make = mk;
        model = mdl;
        color = clr;
        vin = vn;
    }

    // copy constructor
    public Car(String make, String model){
        this.make = make;
        this.model = model;
    }

}
