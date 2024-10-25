package methodstatement;

public class PrimeNumMain {
    public static boolean isPrime(int n){
        // find all num from 2 to n-1
        // if non is divisible, then n is a prime number

        if(n < 2){
            return false;
        }
        for (int i = 2; i < n; i++) {
            System.out.println(i);
            if(n % i == 0) {
                return false;
            }
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            System.out.println(i);
            if(n % i == 0) {
                return false;
            }
        }

        for (int i = 2; i < (n/2); i++) {
            System.out.println(i);
            if(n % i == 0) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPrime(17));
    }
}
