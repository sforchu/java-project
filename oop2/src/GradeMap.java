import java.util.HashMap;
import java.util.TreeMap;

public class GradeMap {
    public static void main(String[] args) {
        HashMap<String, Integer> grades = new HashMap<String, Integer>();
        grades.put("Peter", 70);
        grades.put("Paul", 85);
        grades.put("John", 75);
        grades.put("James", 48);
        grades.put("Simon", 50);

        System.out.println(grades);
        System.out.println("Paul's grade is " + grades.get("Paul"));
        grades.remove("John");
        System.out.println(grades);


        TreeMap<String, Integer> grade = new TreeMap<String, Integer>();
        grade.put("Fanny", 45);
        grade.put("Gael", 45);
        grade.put("Jolie", 80);
        grade.put("Monique", 70);
        grade.put("Nadia", 69);

        System.out.println(grade);
        System.out.println("Gael's grade is " + grade.get("Gael"));
        grade
                .remove("Jolie");
        System.out.println(grade);

    }

}
