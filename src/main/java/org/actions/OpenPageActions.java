package org.actions;

import com.codeborne.selenide.Selenide;


public class OpenPageActions {
    public void skipCaptcha(String url){
        Selenide.sleep(2000);
        Selenide.open(url);
    }
}
