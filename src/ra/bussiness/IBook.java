package ra.bussiness;

import ra.bussinessImp.Book;

import java.util.Scanner;

public interface IBook extends Comparable<Book>{
    void inputData();
    void displayData();

}
