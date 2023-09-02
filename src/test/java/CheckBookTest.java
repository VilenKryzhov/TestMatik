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
    SelenideElement bookItem = $(By.xpath("//option[text()='Books']"));
    SelenideElement searchInput = $(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
    ElementsCollection bookElements = $$(By.xpath("//div[@class='a-section']/div[@class='sg-row']"));
    ElementsCollection titleList = $$(By.xpath("//div/div/h2//span"));
    ElementsCollection authorList = $$(By.xpath("//div[@class='a-row']"));
    List<Books> booksList = new ArrayList<>();

    @Test
    public void test() {
        Selenide.open("https://www.amazon.com/");

        filterButton.shouldBe(Condition.enabled).click();

        bookItem.shouldBe(Condition.visible).click();

        searchInput.shouldBe(Condition.visible).append("Java").sendKeys(Keys.ENTER);
        Selenide.sleep(1000);

        List<String> TitleList = titleList.texts();
        List<String> AuthorList = authorList.texts();
        List<String> filterAuthorList = new ArrayList<>();
        List<String> priceList = $$(By.xpath("//span[@class='a-price-whole']")).texts();

        for (String s : AuthorList) {
            if (s.contains("by")) {
                int elementBy = s.indexOf("By");
                int elementBy2 = s.indexOf("|");
                String substring = s.substring(elementBy + 1, elementBy2 + 1);
                filterAuthorList.add(substring);
            }
        }

        for (int i = 0; i < bookElements.size(); i++) {
            booksList.add(new Books(TitleList.get(i), filterAuthorList.get(i), priceList.get(i)));
        }

        String nameOfBook = null;
        for (Books book : booksList) {
            if (book.getTitle().equals("Head First Java, 2nd Edition")) {
                nameOfBook = book.getTitle();
            }

            System.out.println("Book Name:    " + book.getTitle());
            System.out.println("Book author:  " + book.getAuthor());
            System.out.println("Book price:   $" + book.getPrice());
            System.out.println(" ");

        }
        Assert.assertEquals(nameOfBook, "Head First Java, 2nd Edition");
    }
}