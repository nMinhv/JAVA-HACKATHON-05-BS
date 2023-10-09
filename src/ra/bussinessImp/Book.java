package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

import static ra.run.BookManagement.scanner;

public class Book implements IBook {
    private int bookId;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private String title;
    private String bookName;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, int numberOfPages, float importPrice, float exportPrice, float interest, String title, String bookName, boolean bookStatus) {
        this.bookId = bookId;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.title = title;
        this.bookName = bookName;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        System.out.println("Nhập sách ID(Number):");
        this.bookId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sách");
        this.bookName = scanner.nextLine();
        System.out.println("Nhập tiêu đề sách:");
        this.title = scanner.nextLine();
        System.out.println("Nhập số trang:");
        this.numberOfPages = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giá nhập:");
        this.importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập giá bán Sách:");
        this.exportPrice = Float.parseFloat(scanner.nextLine());
        this.interest = (this.exportPrice - this.importPrice);
        System.out.println("Nhập trạng thái sách :(true - false)");
        this.bookStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("ID: %d - Tên: %s - Tiêu đề: %s\n", this.bookId, this.bookName, this.title);
        System.out.printf("Số trang: %s\ntrạng thái: %s\n", this.numberOfPages, this.bookStatus ? "Đang bán" : "Ngừng bán");
        System.out.printf("giá nhập : %.2f - giá bán : %.2f - lợi nhuận: %.2f\n", this.importPrice, this.exportPrice, this.interest);
        System.out.println();
    }

    @Override
    public int compareTo(Book o) {
        if (this.getInterest() - o.getInterest() > 0) {
            return -1;
        } else if (this.getInterest() - o.getInterest() < 0) {
            return 1;
        }
        return 0;
    }
}
