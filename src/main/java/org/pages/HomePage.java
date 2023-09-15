package org.pages;

import org.base.PageTools;
import org.openqa.selenium.By;

public class HomePage extends PageTools {
    By filterButton = By.xpath("(//div[@class='nav-left'])[2]");
    By booksItem = By.xpath("//option[text()='Books']");
    By searchInput = By.xpath("//input[@id=\"twotabsearchtextbox\"]");

    public void clickFilterButtotn() {
        click(filterButton);
    }

    public void clickBooksFilter() {
        click(booksItem);
    }

    public void typeValueInInput(String value) {
        type(value , searchInput);
        clickEnterButton();
    }

}
