package operation;

import book.BookList;

import java.util.Scanner;

public interface IOperation {
    public void work(BookList bookList);
    Scanner scanner = new Scanner(System.in);
}
