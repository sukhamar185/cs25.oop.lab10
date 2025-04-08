package lib;
import java.util.*;

public class Library {

    private BookShelf shelf = new BookShelf();

    public void addBook(String title, int year) {
        shelf.add(new Book(title, year));
    }

    public Iterable<Book> getRecentBooks(int minYear) {
        List<Book> recent = new ArrayList<>();
        for (Book b : shelf) {
            if (b.getYear() > minYear) {
                recent.add(b);
            }
        }
        return recent;
    }

    private class BookShelf implements Iterable<Book> {
        private List<Book> books = new ArrayList<>();

        public void add(Book book) {
            books.add(book);
        }

        @Override
        public Iterator<Book> iterator() {
            return books.iterator();
        }
    }

    public static class Book {
        private String title;
        private int year;

        public Book(String title, int year) {
            this.title = title;
            this.year = year;
        }

        public String getTitle() {
            return title;
        }

        public int getYear() {
            return year;
        }
    }
}
