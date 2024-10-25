package cprator;

import java.util.Comparator;

public class Book {
    public String title;
    public String author;
    public int price;

    // constructor
    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // tostring
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}

class PriceComparator implements Comparator<Book> {

    @Override
    public int compare(Book bk1, Book bk2) {
        return bk1.price - bk2.price;
    }
}

class TitleComparator implements Comparator<Book> {

    @Override
    public int compare(Book bk1, Book bk2) {
        return bk1.title.compareTo(bk2.title);
    }
}

class AuthorComparator implements Comparator<Book> {

    @Override
    public int compare(Book bk1, Book bk2) {
        return bk1.author.compareTo(bk2.author);
    }
}