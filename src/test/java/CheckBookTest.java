import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.base.BaseTest;
import org.base.Books;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckBookTest extends BaseTest {

    SelenideElement filterButton = $(By.xpath("(//div[@class='nav-left'])[2]"));
    SelenideElement bookItem = $(By.xpath("//*[@id=\"searchDropdownBox\"]/option[6]"));
    SelenideElement searchInput = $(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
    ElementsCollection bookElements = $$(".s-result-item");

    List<Books> booksList = new ArrayList<>();

    @Test
    public void test() {
        Selenide.open("https://www.amazon.com/");

        filterButton.shouldBe(Condition.enabled).click();

        bookItem.shouldBe(Condition.visible).click();

        searchInput.shouldBe(Condition.visible).append("Java").sendKeys(Keys.ENTER);

        for (SelenideElement item : bookElements) {
            item.shouldBe(Condition.visible);
            String title = item.$(By.xpath("//div/div/h2//span")).getText();
            String author = item.$("div.a-row.a-size-base.a-color-secondary span:contains('by ')").getText().replace("by ", "");
            String price = item.$("span.a-price").getText();

            booksList.add(new Books(title, author, price));
        }

        for (Books book : booksList) {
            Assert.assertEquals(book.getTitle(), "Head First Java, 2nd Edition");

        }
    }
}