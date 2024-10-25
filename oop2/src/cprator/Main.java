package cprator;


import compare.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        compare.Book book1 = new compare.Book("Jack the reaper", "Jack", 90);
        compare.Book book2 = new compare.Book("Drone Man", "Carl", 75);
        compare.Book book3 = new compare.Book("Games guru", "Jet Moore", 60);

        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);


        System.out.println(books);

        Collections.sort(books);

//        Collections.sort(books, new TitleComparator());

        System.out.println(books);

//        Collections.sort(books, new AuthorComparator());

        System.out.println(books);





//        Student student1 = new Student("James", 35);
//        Student student2 = new Student("Paul", 30);
//        Student student3 = new Student("John", 40);
//
//
//        ArrayList<Student> students = new ArrayList<>();
//        students.add(student1);
//        students.add(student2);
//        students.add(student3);
//
//        System.out.println(students);
//
//        Collections.sort(students, new NameAgeComparator());
//
//        System.out.println(students);



    }
}
