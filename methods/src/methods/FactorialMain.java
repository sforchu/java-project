package methods;

public class FactorialMain {
    public static int factorial(int n){
        int sum = n;
        for (int i = n; i > 2; i--){
            sum = sum * (i-1);
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(factorial(4));
    }
}
