package org.actions;

import com.codeborne.selenide.Selenide;
import org.objects.Book;

import java.util.List;

public class BooksActions {
    List<Book> booksList;
    public Book createExpectedBook(String nameBook, String authorsName, String price) {
        return new Book(nameBook, authorsName, price);
    }
    public Book createBook(String nameBook, String authorsName, String price) {
        return new Book(nameBook, authorsName, price);
    }
    public void addBookToList(Book book){
       booksList.add(book);
    }
    public void navigateBackPage() {
        Selenide.back();
    }

}