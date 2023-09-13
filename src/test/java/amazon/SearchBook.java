package amazon;

import org.actions.Actions;
import org.base.BaseTest;
import org.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.core.utils.Constants.AMAZON_URL;

public class SearchBook extends BaseTest {
    List<String> filterAuthorList = new ArrayList<>();


    @Test
    public void test() {

        Actions.openPage().skipCaptcha(AMAZON_URL);

        Pages.homePage().clickFilterButtotn();

        Pages.homePage().clickFilterButtotn();

        Pages.homePage().clickBooksFilter();

        Pages.homePage().typeValueInInput("Java");

        List<String> titleList = Pages.homePage().getTitleList();
        List<String> authorList = Pages.homePage().getAuthorList();
        List<String> priceList = Pages.homePage().getPriceList();

        Actions.booksActions().getFilterAuthorList(authorList, filterAuthorList);

        Actions.booksActions().createBooksList(titleList,filterAuthorList,priceList);

        String nameOfBook = Actions.booksActions().getNameOfBook();

        Assert.assertEquals(nameOfBook, "Head First Java, 2nd Edition");
    }
}