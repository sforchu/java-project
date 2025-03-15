import java.util.Arrays;

public class ExerTimeComplex {
    public static void main(String[] args) {
        int arraySize = 60000000;
        int[] numbers = new int[arraySize];

       double startTime = System.currentTimeMillis();
        System.out.println(startTime);

       for (int i = 0; i < arraySize; i++) {
           numbers[i] = i + 1;
       }

       double endTime = System.currentTimeMillis();
        System.out.println(endTime);

        // Calculate and print the time taken
        double timeTaken = endTime - startTime;
        System.out.println("Time taken to populate the array: " + timeTaken + " milliseconds");

//        System.out.println(Arrays.toString(numbers));
    }
}
