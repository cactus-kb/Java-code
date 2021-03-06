package operation;

import book.Book;
import book.BookList;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入归还书籍名称");
        String name = scanner.next();
        int i = 0;
        Book book = null;
        for (; i < bookList.getUsedSize(); i++) {
            if (bookList.getBooks(i).getName().equals(name)) {
                System.out.println(bookList.getBooks(i));
                book = bookList.getBooks(i);
                break;
            }
        }
        if (i > bookList.getUsedSize()) {
            System.out.println("没有此书籍");
            return;
        }
        if (book != null && book.isBorrowed()) {
            System.out.println("此书未被借阅");
            return;
        }
        if (book != null && book.isBorrowed()) {
            book.setBorrowed(false);
        }
        System.out.println("归还完成");
    }
}
