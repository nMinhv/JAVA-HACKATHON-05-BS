package ra.run;

import ra.bussinessImp.Book;

import java.util.*;

public class BookManagement {
    public static List<Book> bookList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        bookList.add(new Book(1, 3, 2, 3, 1, "book1", "book1", true));
        bookList.add(new Book(2, 3, 2, 6, 3, "book3", "book3", true));
        bookList.add(new Book(3, 3, 5, 7, 2, "book2", "book3", true));
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU**************");
            System.out.println("1. Nhập số sách và nhập thông tin sách ");
            System.out.println("2. Hiển thị thông tin các sách ");
            System.out.println("3. Sắp xếp sách theo lợi nhuận giảm dần ");
            System.out.println("4. Xóa sách theo mã sách ");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi trạng thái của sách theo mã sách");
            System.out.println("7. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addBooks();
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    sortBookByInterest();
                    break;
                case 4:
                    deledeBookById();
                    break;
                case 5:
                    findBookByName();
                    break;
                case 6:
                    changeStatusBooksById();
                    break;
                case 7:
                    scanner.close();
                    System.exit(0);
            }
        }
    }

    public static void addBooks() {
        System.out.println("Nhập số lượng sách muốn thêm:");
        int numberOfBooks = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfBooks; i++) {
            Book newBook = new Book();
            newBook.inputData();
            bookList.add(newBook);
        }
    }

    public static void displayBooks() {
        for (Book book : bookList
        ) {
            book.displayData();
        }
    }

    public static void sortBookByInterest() {
        bookList.sort(Book::compareTo);
    }

    public static void findBookByName() {
        System.out.println("Nhập tên sách muốn tìm:");
        String searchName = scanner.nextLine();
        for (Book book : bookList
        ) {
            if (book.getBookName().contains(searchName)) {
                book.displayData();
            }
        }
    }

    public static void changeStatusBooksById() {
        System.out.println("Nhập id sách muốn sửa");
        int bookId = Integer.parseInt(scanner.nextLine());
        int bookIndex = bookIndex(bookId);
        if (bookIndex >= 0) {
            System.out.println("Nhập trạng thái sách(true - false):");
            boolean changeStatus = Boolean.parseBoolean(scanner.nextLine());
            bookList.get(bookIndex).setBookStatus(changeStatus);
            bookList.set(bookIndex, bookList.get(bookIndex));
        } else {
            System.out.println("Không tìm thấy sách có id " + bookId);
        }
    }

    public static void deledeBookById() {
        System.out.println("Nhập id sách muốn xóa:");
        int bookId = Integer.parseInt(scanner.nextLine());
        int bookIndex = bookIndex(bookId);
        if (bookIndex >= 0) {
            bookList.remove(bookIndex);
        } else {
            System.out.println("Không tìm thấy sách có id " + bookId);
        }
    }

    public static int bookIndex(int bookId) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getBookId() == bookId) {
                return i;
            }
        }
        return -1;
    }
}
