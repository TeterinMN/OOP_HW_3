import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Library implements Iterable<Book> {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void sortBooksByTitle() {
        Collections.sort(books);
    }

    public void sortBooksByAuthor() {
        Collections.sort(books, Book.AuthorComparator);
    }

    public void sortBooksByYear() {
        Collections.sort(books, Book.YearComparator);
    }

    @Override
    public Iterator<Book> iterator() {
        return books.iterator();
    }
}