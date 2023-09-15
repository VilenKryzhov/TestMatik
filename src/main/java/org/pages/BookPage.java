package org.pages;

import org.base.PageTools;
import org.objects.Book;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookPage extends PageTools {

    By bookName = By.xpath("//span[@id='productTitle']");
    By authorName = By.xpath("//span[@class='author notFaded']//a");
    By price = By.xpath("//span[@class='a-color-base']");


    public Book getExpectedBook() {
        Book book = new Book();
        book.setTitle(getElementText(bookName));
        book.setAuthor(String.join(" and ", getElementsText(authorName)));
        String priceText = getElementText(price);
        String[] prices = priceText.split("-");
        if (prices.length >= 2) {
            String extractedPrice = prices[1].trim();
            book.setPrice(extractedPrice);
        }

        return book;
    }


}
