import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudNames {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<String>();

        studentNames.add("Peter");
        studentNames.add("James");
        studentNames.add("Paul");
        studentNames.add("Mike");
        studentNames.add("Steve");

        System.out.println(studentNames);
        System.out.println(studentNames.size());
        System.out.println(studentNames.get(2));
        studentNames.remove(0);
        System.out.println(studentNames);



    }
}
