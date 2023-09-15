package amazon;

import org.actions.Actions;
import org.base.BaseTest;
import org.objects.Book;
import org.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.core.utils.Constants.AMAZON_URL;

public class SearchBookTest extends BaseTest {

    @Test
    public void test() {

        Actions.openPage().skipCaptcha(AMAZON_URL);

        Pages.homePage().clickFilterButtotn();

        Pages.homePage().clickFilterButtotn();

        Pages.homePage().clickBooksFilter();

        Pages.homePage().typeValueInInput("Java");

        Pages.booksCatalogPage().clickToExpectedBook();

        Book expectedBook = Pages.bookPage().getExpectedBook();

        Actions.booksActions().navigateBackPage();

        List<Book> booksList = Pages.booksCatalogPage().getBooks();


        for (Book book : booksList) {
            System.out.println(book.getTitle());
            System.out.println(book.getAuthor());
            System.out.println(book.getPrice());
            System.out.println("_________________");

        }

        System.out.println(expectedBook);

        Assert.assertTrue(booksList.contains(expectedBook));
    }
}