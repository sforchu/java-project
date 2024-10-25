package methods;

public class MyCar {

    public void fullThrottle(){
        System.out.println("The car is going as fast as it can!");
    }


    public void speed(int maxSpeed){
        System.out.println("Max speed is: " + maxSpeed);

    }

    public static void main(String[] args) {
        MyCar car = new MyCar();
        car.fullThrottle();
        car.speed(220);
    }

}
