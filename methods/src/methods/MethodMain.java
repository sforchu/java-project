package methods;

public class MethodMain {

    public static int doubleNum(int num){
        return num * 2;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.add(4, 9);
        System.out.println(result);
        // System.out.println(calculator.add(4, 9));

        calculator.displayMessage("This is my Java study");

        int result1 = Calculator.square(5);
        System.out.println(result1);

        System.out.println(doubleNum(3)); // calling the doubleNum method within the MethodMain

    }
}
