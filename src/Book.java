import java.util.Comparator;

record Book(String title, String author, int publishedYear) implements Comparable<Book> {

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishedYear=" + publishedYear +
                '}';
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    public static Comparator<Book> AuthorComparator = Comparator.comparing(Book::author);

    public static Comparator<Book> YearComparator = Comparator.comparingInt(Book::publishedYear);
}