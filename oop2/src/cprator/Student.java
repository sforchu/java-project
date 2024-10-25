package cprator;

import java.util.Comparator;

public class Student {
    public String name;
    public int age;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    @Override
//    public int compareTo(compare.Student student) {
//        return this.age -student.age;
//    }
}

//class AgeComparator implements Comparator<Student> {
//
//    @Override
//    public int compare(Student st1, Student st2) {
//        return st2.age - st1.age;
//    }
//}
//
//class NameComparator implements Comparator<Student> {
//
//    @Override
//    public int compare(Student st1, Student st2) {
//        return st1.name.compareTo(st2.name);
//    }
//}

class NameAgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student st1, Student st2) {
       int result =  st1.name.compareTo(st2.name);
       if(result == 0){
           result  = st1.age - st2.age;
       }
       return result;
       }
    }

