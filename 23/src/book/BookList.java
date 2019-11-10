package book;

import java.util.Arrays;

public class BookList {
    private Book[] books = new Book[100];
    private int usedSize = 0;


    public BookList() {
        books[0] = new Book("java","kk",12,"study");
        books[1] = new Book("c","jj",13,"study");
        books[2] = new Book("c++","ll",14,"study");
        books[3] = new Book("python","bb",15,"study");
        this.usedSize = 4;


    }

    public Book getBooks(int pos) {
        return this.books[pos];
    }

    public void setBooks(int pos,Book book) {
        this.books[pos] = book;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public void setBook(int j, Book book) {

    }
}
