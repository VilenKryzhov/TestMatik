package org.pages;

public class Pages {
    private static HomePage homePage;
    private static BooksCatalogPage booksCatalogPage;
    private static BookPage bookPage;

    public static HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public static BooksCatalogPage booksCatalogPage() {
        if (booksCatalogPage == null) {
            booksCatalogPage = new BooksCatalogPage();
        }
        return booksCatalogPage;
    }

    public static BookPage bookPage() {
        if (bookPage == null) {
            bookPage = new BookPage();
        }
        return bookPage;
    }
}