package methods;

// instance method (non-void), called by created an instance of the class
public class Calculator {
    public int add(int num1, int num2){
        return num1 + num2;
    }

    // void method, does not return an output
    public void displayMessage(String message){
        System.out.println(">>>"+ message);
    }

    // static method (non-void), called directly
    public static int square(int num){
        return num * num;
    }

}
