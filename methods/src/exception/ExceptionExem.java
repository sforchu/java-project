package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExem {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter two number");
//        try {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            int result = a / b;
//            System.out.println("Result: " + result);
//        } catch (InputMismatchException e){
//            System.out.println("Oops you have an InputMismatchException, Only integers are expected");
//        } catch (ArithmeticException ex){
//            System.out.println("Oops you have an Arithmetic exception" + ex.getMessage());
//        }  finally {
//            System.out.println("I am done");
//        }


        File file = new File("myfile.txt");
        try {
            FileInputStream io = new FileInputStream(file);
        } catch (FileNotFoundException ex){
            System.out.println("Oops file not found");
        }
    }


}
