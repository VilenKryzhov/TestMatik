package org.actions;

public class Actions {
    private static OpenPageActions openPage;
    public static OpenPageActions openPage() {
        if (openPage == null) {
            openPage = new OpenPageActions();
        }
        return openPage;
    }
}
