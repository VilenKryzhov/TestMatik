package org.pages;

import org.actions.BooksActions;
import org.base.PageTools;
import org.objects.Book;
import org.openqa.selenium.By;

public class BookPage extends PageTools {
    BooksActions booksActions = new BooksActions();
    By bookName = By.xpath("//span[@id='productTitle']");
    By authorName = By.xpath("//span[@class='author notFaded']//a");
    By price = By.xpath("//span[@class='a-color-base']");


    public Book getExpectedBook() {
        return booksActions.getExpectedBook(bookName, authorName, price);
    }


}
