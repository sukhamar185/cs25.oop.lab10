package lib;
public class LibApp {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook("Gedes", 1921);
        lib.addBook("1984", 1949);
        lib.addBook("Svvn Zam", 2020);

        for (Library.Book b : lib.getRecentBooks(2000)) {
            System.out.println(b.getTitle() + ": " + b.getYear());
        }
    }
}
