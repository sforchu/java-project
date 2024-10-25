import java.util.ArrayList;

public class Grades {
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        grades.add(23);
        grades.add(67);
        grades.add(78);
        grades.add(90);
        grades.add(45);
        grades.add(3);

        System.out.println(grades);

        grades.remove(Integer.valueOf(3));





        System.out.println(grades);

        System.out.println(grades.get(3));
        System.out.println("The first grade is " + grades.getFirst());
        System.out.println("The size of the ArrayList is " + grades.size());
        grades.remove(3);
        System.out.println("The size of the ArrayList after removing index 3 is " + grades.size());
        System.out.println(grades);
        grades.add(4 , 55);
        System.out.println("The size of the ArrayList after adding index 4 with grade 55 is " + grades.size());
        System.out.println(grades);
        grades.clear();
        System.out.println("We have an empty list after clearing everything " + grades);

    }
}
