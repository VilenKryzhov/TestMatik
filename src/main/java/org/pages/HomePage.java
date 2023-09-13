package org.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.objects.Books;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {
    SelenideElement filterButton = $(By.xpath("(//div[@class='nav-left'])[2]"));
    SelenideElement booksItem = $(By.xpath("//option[text()='Books']"));
    SelenideElement searchInput = $(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
    ElementsCollection titleList = $$(By.xpath("//div/div/h2//span"));
    ElementsCollection authorList = $$(By.xpath("//div[@class='a-row']"));
    ElementsCollection priceList = $$(By.xpath("//span[@class='a-price-whole']"));
    List<Books> booksList = new ArrayList<>();
    String nameOfBook = null;


    public void clickFilterButtotn() {
        filterButton.shouldBe(Condition.enabled).click();
    }

    public void clickBooksFilter() {
        booksItem.shouldBe(Condition.enabled).click();
    }

    public void typeValueInInput(String value) {
        searchInput.shouldBe(Condition.visible).append(value).sendKeys(Keys.ENTER);
    }

    public List<String> getTitleList() {
        return titleList.texts();
    }

    public List<String> getAuthorList() {
        return authorList.texts();
    }

    public List<String> getPriceList() {
        return priceList.texts();
    }



}
