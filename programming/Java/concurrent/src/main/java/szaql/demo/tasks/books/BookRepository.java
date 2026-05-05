package szaql.demo.tasks.books;

import java.net.URL;
import java.util.List;

class BookRepository {
    private List<Book> bookList = List.of(new Book("Frankenstein","https://www.gutenberg.org/cache/epub/84/pg84.txt"));

    public List<Book> getBookList() {
        return bookList;
    }
}
