import java.util.ArrayList;
import java.util.Arrays;

public class DataStructure {
    public static void main(String[] args) {

//        int[] numbers = {2, 4, 6};
//
//        // loop thru the array
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] *= 3;
//        }
//
//        System.out.println(Arrays.toString(numbers));

        Student[] students = new Student[3];
        students[0] = new Student(69, "Eddy");
        students[1] = new Student(22, "Diddy");
        students[2] = new Student(22, "Smith");

        displayArray(students);
        transformCopyArray(students);
        displayArray(students);
    }

    private static void displayArray(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getName());
        }
    }

    private static void transformArray(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            student.setName(student.getName().toUpperCase());
        }
    }

    private static void transformCopyArray(Student[] students) {
        Student[] cloned_students = deepCopyArray(students);
        for (int i = 0; i < cloned_students.length; i++) {
            Student student = cloned_students[i];
            student.setName(student.getName().toUpperCase());
        }
    }

    private static Student[] deepCopyArray(Student[] students) {
        Student[] studs = new Student[students.length];
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            Student newStudent = new Student(student.getAge(), student.getName());
            studs[i] = newStudent;

        }
        return studs;
    }

}
