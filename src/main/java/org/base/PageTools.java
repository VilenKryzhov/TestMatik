package org.base;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageTools {

    protected SelenideElement shouldBe(Condition condition, By by, Object... args) {
        return $(by).shouldBe(condition);
    }



    protected boolean shouldBeVisible(Condition condition, By by, Object... args) {
        $(by).shouldBe(condition);
        return true;
    }

    protected SelenideElement should(Condition condition, By by, int sec, Object... args) {
        return $(by).should(condition, Duration.ofMillis(sec));
    }

    protected SelenideElement waitUntil(Condition condition, By by, int sec, Object... args) {
        return $(by).waitUntil(condition, sec);
    }

    protected ElementsCollection shouldBe(CollectionCondition condition, By by, Object... args) {
        return $$(by).shouldBe(condition);
    }

    protected void type(String text, By by, Object... args) {
        shouldBe(Condition.visible, by).append(text);
    }

    protected void click(By by, Object... args) {
        shouldBe(Condition.enabled, by).click();
    }

    protected void clickSelenide(By by, Object... args) {
        shouldBe(Condition.enabled, by).click();
    }

    protected void append(By by, String text, Object... args) {
        shouldBe(Condition.visible, by).append(text);
    }

    protected void waitUntilElementVisibility(By by, Integer time, Object... args) {
        $(by).waitUntil(Condition.visible, time);
    }

    protected void waitUntilElementInvisibility(By by, Integer time, Object... args) {
        $(by).waitUntil(Condition.hidden, time);
    }

    public String getElementText(By by, Object... args) {
        return shouldBe(Condition.visible, by).text();
    }

    public List<String> getElementsText(By by, Object... args) {
        return shouldBe(CollectionCondition.sizeGreaterThan(-1), by).texts();
    }

    public List<SelenideElement> getElements(By by, Object... args) {
        return shouldBe(CollectionCondition.sizeGreaterThan(-1), by, args);
    }

    public SelenideElement getElement(By by, Object... args) {
        return shouldBe(Condition.visible, by);
    }

    protected void clickEnterButton() {
        Selenide.actions().sendKeys(Keys.ENTER).perform();
    }

    protected void backToHomePage() {
        Selenide.actions().sendKeys(Keys.ARROW_LEFT).perform();
    }

    protected void scrollIntoView(By by) {
        Selenide.actions().moveToElement(Selenide.$(by)).perform();
    }

    public boolean isElementExist(By by, Object... args) {
        return $(by).is(Condition.visible);
    }
}