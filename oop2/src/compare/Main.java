package compare;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Jack the reaper", "Jack", 90);
        Book book2 = new Book("Drone Man", "Carl", 75);
        Book book3 = new Book("Games guru", "Jet Moore", 60);

        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);


        System.out.println(books);

        Collections.sort(books);

        System.out.println(books);

    }


}
