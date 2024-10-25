//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Vehicle vehicle = new Vehicle();
//        vehicle.name = "Lexus";
//        vehicle.lnumber = "HY'S&*D";
//        vehicle.coOwner = new Vehicle.CoOwner();
//        vehicle.owner = new Owner();

        // creating GreetingImpl
//        GreetingImpl greeting = new GreetingImpl();
//        greeting.sayHello();

        //anonymous inner class
//        Greeting greeting = new Greeting() {
//            @Override
//            public void sayHello() {
//                System.out.println("Hello from anonymous class");
//
//            };
//        };
        // lambda expression, same as above code (//anonymous inner class). Lambda expression helps reduce lines of code
        Greeting greeting = () -> System.out.println("Hello from anonymous class");

        greeting.sayHello();



        }
    }
