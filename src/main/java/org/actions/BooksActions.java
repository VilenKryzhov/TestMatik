package org.actions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.base.PageTools;
import org.objects.Book;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BooksActions extends PageTools {
    List<Book> booksList;

    public Book getExpectedBook(By bookName, By authorName, By price) {
        Book book = new Book();
        book.setTitle(getElementText(bookName));
        book.setAuthor(String.join(" and ", getElementsText(authorName)));
        String priceText = getElementText(price);

        Pattern pattern = Pattern.compile("\\$\\d+\\.\\d{2}\\s*-\\s*(\\$\\d+\\.\\d{2})");
        Matcher matcher = pattern.matcher(priceText);

        if (matcher.find()) {
            String extractedPrice = matcher.group(1);
            book.setPrice(extractedPrice);
        }
        return book;
    }


    public Book createBook(String nameBook, String authorsName, String price) {
        return new Book(nameBook, authorsName, price);
    }

    public void addBookToList(Book book) {
        booksList.add(book);
    }

    public void navigateBackPage() {
        Selenide.back();
    }

    public List<Book> getBooksList(By nameBook, By author, By priceDlrs, By priceCent, By booksElements) {
        List<Book> books = new ArrayList<>();
        List<String> titles = getElementsText(nameBook);
        List<String> authors = getElementsText(author);
        List<String> priceDlrsList = getElementsText(priceDlrs);
        List<String> priceCnt = getElementsText(priceCent);
        List<String> priceActual = new ArrayList<>();

        for (int i = 0; i < priceDlrsList.size(); i++) {
            String price = "$" + priceDlrsList.get(i);
            priceDlrsList.set(i, price);
            String priceForActual = priceDlrsList.get(i) + "," + priceCnt.get(i);
            priceActual.add(priceForActual);
        }

        List<SelenideElement> elements = getElements(booksElements);
        List<String> prices = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            SelenideElement element = elements.get(i);
            String elementText = element.text();
            String price = "0";

            for (String item : priceDlrsList) {
                if (elementText.contains(item)) {
                    int index = priceDlrsList.indexOf(item);
                    if (index >= 0 && index < priceActual.size()) {
                        price = priceActual.get(index);
                    }
                    break;
                }
            }

            prices.add(price);
        }

        for (int i = 0; i < titles.size(); i++) {
            if (authors.get(i).contains("by")) {
                authors.set(i, authors.get(i).replaceAll(".*by(.*?)\\|.*", "$1").trim());
            }
            Book book = new Book(titles.get(i), authors.get(i), prices.get(i));
            books.add(book);
        }

        return books;
    }

}