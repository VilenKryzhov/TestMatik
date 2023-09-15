package org.pages;

import org.actions.BooksActions;
import org.base.PageTools;
import org.objects.Book;
import org.openqa.selenium.By;

import java.util.List;

public class BooksCatalogPage extends PageTools {
    BooksActions booksActions = new BooksActions();
    By booksElements = By.xpath("//div[@class='a-section']//div[@class='a-section" +
            " a-spacing-small a-spacing-top-small']");

    By priceDlrs = By.xpath("//a[text()='Paperback']" +
            "/ancestor::div[contains(@class,'puis-price-instructions-style')]//span[@class='a-price-whole']");
    By priceCent = By.xpath("//a[text()='Paperback']" +
            "/ancestor::div[contains(@class,'puis-price-instructions-style')]//span[@class='a-price-fraction']");


    By nameBook = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
    By expectedBook = By.xpath("//span[text()='Head First Java, 2nd Edition']");
    By author = By.xpath("//div[@class='a-row a-size-base a-color-secondary']//div[@class='a-row']");


    public List<Book> getBooks() {
        return booksActions.getBooksList(nameBook, author, priceDlrs, priceCent, booksElements);
    }

    public void clickToExpectedBook() {
        click(expectedBook);
    }


}
