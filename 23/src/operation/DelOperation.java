package operation;

import book.Book;
import book.BookList;

public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("请输入删除图书的名字");
        String name = scanner.next();
        int i = 0;
        for (; i < bookList.getUsedSize(); i++) {
            if (bookList.getBooks(i).getName().equals(name)) {
                break;
            }
        }
        if (i >= bookList.getUsedSize()) {
            System.out.println("没有删除的书籍");
            return;
        }
        for (int j = i; j < bookList.getUsedSize() - 1; j++) {
            Book book = bookList.getBooks(j + 1);
            bookList.setBooks(j,book);
        }
        bookList.setUsedSize(bookList.getUsedSize() - 1);
    }
}
