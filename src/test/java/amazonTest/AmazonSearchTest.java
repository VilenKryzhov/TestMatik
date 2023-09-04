package amazonTest;

import org.amazon.AmazonBooksPage;
import org.base.BaseTest;
import org.amazon.Books;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AmazonSearchTest extends BaseTest {
    String url = "https://www.amazon.com/ ";
    AmazonBooksPage amazonBooksPage = new AmazonBooksPage();
    List<Books> booksList = new ArrayList<>();
    List<String> filterAuthorList = new ArrayList<>();

    @Test
    public void test() {
        amazonBooksPage.openAmazonHomePage(url);

        amazonBooksPage.clickFilterButtotn();

        amazonBooksPage.clickBooksFilter();

        amazonBooksPage.typeValueInInput("Java");

        List<String> titleList = amazonBooksPage.getTitleList();
        List<String> authorList = amazonBooksPage.getAuthorList();

        amazonBooksPage.getFilterAuthorList(authorList, filterAuthorList);

        List<String> priceList = amazonBooksPage.getPriceList();

        for (int i = 0; i < titleList.size(); i++) {
            booksList.add(new Books(titleList.get(i), filterAuthorList.get(i)
                    , priceList.get(i)));
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