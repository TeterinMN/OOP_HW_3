import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Удалить книгу");
            System.out.println("3. Посмотреть книги в библиотеке");
            System.out.println("4. Сортировка книг");
            System.out.println("5. Выход");

            System.out.print("Введите число (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook(library, scanner);
                    break;
                case 2:
                    removeBook(library, scanner);
                    break;
                case 3:
                    viewAllBooks(library);
                    break;
                case 4:
                    sortBooks(library, scanner);
                    break;
                case 5:
                    System.out.println("Выход. Досвидания!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, введите число от 1 до 5.");
            }
        }
    }

    private static void addBook(Library library, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Название книги: ");
        String title = scanner.nextLine();
        System.out.print("Автор: ");
        String author = scanner.nextLine();
        System.out.print("Дата публикации: ");
        int publishedYear = scanner.nextInt();

        Book newBook = new Book(title, author, publishedYear);
        library.addBook(newBook);
        System.out.println("Книга успешно добавлена!");
    }

    private static void removeBook(Library library, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Введите название книги для удаления из базы: ");
        String titleToRemove = scanner.nextLine();

        boolean removed = library.getBooks().removeIf(book -> book.title().equals(titleToRemove));

        if (removed) {
            System.out.println("Книга удалена из базы данных, успешно!");
        } else {
            System.out.println("Нет такой книги в базе данных");
        }
    }

    private static void viewAllBooks(Library library) {
        System.out.println("\nВсе книги:");
        for (Book book : library) {
            System.out.println(book);
        }
    }

    private static void sortBooks(Library library, Scanner scanner) {
        System.out.println("\nСортировка:");
        System.out.println("1. По названию");
        System.out.println("2. По автору");
        System.out.println("3. По дате публикации");
        System.out.print("Введите число (1-3): ");
        int sortChoice = scanner.nextInt();

        switch (sortChoice) {
            case 1:
                library.sortBooksByTitle();
                System.out.println("Книги отсортированы по названию.");
                break;
            case 2:
                library.sortBooksByAuthor();
                System.out.println("Книги отсортированы по автору.");
                break;
            case 3:
                library.sortBooksByYear();
                System.out.println("Книги отсортированы по дате публикации.");
                break;
            default:
                System.out.println("Неверный ввод. Пожалуйста, введите число от 1 до 3.");
        }
    }
}
