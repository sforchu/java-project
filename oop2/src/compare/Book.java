package compare;

public class Book implements Comparable<Book> {
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

    @Override
    public int compareTo(Book book) {
        return this.price - book.price;
    }


    }

