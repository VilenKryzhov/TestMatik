package org.pages;

public class Pages {
    private static HomePage homePage;

    public static HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }
}
