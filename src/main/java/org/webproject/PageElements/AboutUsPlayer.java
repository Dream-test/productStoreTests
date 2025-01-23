package org.webproject.PageElements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AboutUsPlayer {
    public static final SelenideElement title  = $(By.cssSelector("h5#videoModalLabel"));
    public static final SelenideElement getPlayerButton = $(By.className("vjs-big-play-button"));
    //public static final SelenideElement closeButton = $(Selectors.byTagAndText("button", "Close"));
    public static final SelenideElement closeButton = $(By.xpath("//*[@id=\"videoModal\"]/div/div/div[3]/button"));
    public static final SelenideElement videoPlayer = $(By.cssSelector("video#example-video_html5_api"));
    public static final SelenideElement vjsControlButton = $(By.cssSelector("button.vjs-play-control.vjs-control.vjs-button"));



    public static void waitAboutUsPlayerIsLoaded() {
        title.shouldBe(visible);
    }

    public static void clickCloseButton() {
        closeButton.click();
        title.should(disappear);
    }

    public static void clickGetPlayerButton() {
        getPlayerButton.click();
        videoPlayer.shouldBe(visible).shouldHave(Condition.attributeMatching("src", "blob:https://demoblaze.com/.+"));
    }

    public static void clickByPlayerWindow() {
        videoPlayer.click();
    }

    public static String getTitleVjsControlButton() {
        return vjsControlButton.getAttribute("title");
    }
}
