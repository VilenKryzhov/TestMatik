package org.amazon;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AmazonBooksPage {
    SelenideElement filterButton = $(By.xpath("(//div[@class='nav-left'])[2]"));
    SelenideElement booksItem = $(By.xpath("//option[text()='Books']"));
    SelenideElement searchInput = $(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
    ElementsCollection titleList = $$(By.xpath("//div/div/h2//span"));
    ElementsCollection authorList = $$(By.xpath("//div[@class='a-row']"));
    ElementsCollection priceList = $$(By.xpath("//span[@class='a-price-whole']"));

    public void openAmazonHomePage(String url) {
        Selenide.open(url);
    }
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

    public List<String> getFilterAuthorList(List<String> list, List<String> filterList) {
        for (String s : list) {
            if (s.contains("by")) {
                int elementBy = s.indexOf("By");
                int elementBy2 = s.indexOf("|");
                String substring = s.substring(elementBy + 1, elementBy2 + 1);
                filterList.add(substring);
            }
        }
        return filterList;
    }


}
