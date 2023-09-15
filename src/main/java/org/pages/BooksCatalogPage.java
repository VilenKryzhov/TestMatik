package org.pages;

import com.codeborne.selenide.SelenideElement;
import org.base.PageTools;
import org.objects.Book;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class BooksCatalogPage extends PageTools {
    By booksElements = By.xpath("//div[@class='a-section']//div[@class='a-section" +
            " a-spacing-small a-spacing-top-small']");

    By priceDlrs = By.xpath("//a[text()='Paperback']" +
            "/ancestor::div[contains(@class,'puis-price-instructions-style')]//span[@class='a-price-whole']");
    By priceCent = By.xpath("//a[text()='Paperback']" +
            "/ancestor::div[contains(@class,'puis-price-instructions-style')]//span[@class='a-price-fraction']");


    By nameBook = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
    By expectedBook = By.xpath("//span[text()='Head First Java, 2nd Edition']");
    By author = By.xpath("//div[@class='a-row a-size-base a-color-secondary']//div[@class='a-row']");


    public List<Book> getBooksList() {
        List<Book> books = new ArrayList<>();
        List<String> titles = getElementsText(nameBook);
        List<String> authors = getElementsText(author);
        List<String> priceDlrs = getElementsText(this.priceDlrs);
        List<String> priceCnt = getElementsText(priceCent);
        List<String> priceActual = new ArrayList<>();

        for (int i = 0; i < priceDlrs.size(); i++) {
            String price = "$" + priceDlrs.get(i);
            priceDlrs.set(i, price);
            String priceForActual = priceDlrs.get(i) + "," + priceCnt.get(i);
            priceActual.add(priceForActual);
        }

        List<SelenideElement> elements = getElements(booksElements);
        List<String> prices = new ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            SelenideElement element = elements.get(i);
            String elementText = element.text();
            String price = "0";

            for (String item : priceDlrs) {
                if (elementText.contains(item)) {
                    int index = priceDlrs.indexOf(item);
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

    public void clickToExpectedBook() {
        click(expectedBook);
    }


}
