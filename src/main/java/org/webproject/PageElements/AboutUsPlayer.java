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
    public static final SelenideElement closeButton = $(Selectors.byTagAndText("button", "Close"));
    public static final SelenideElement videoPlayer = $(By.cssSelector("video#example-video_html5_api"));
    public static final SelenideElement vjsControlButton = $(By.cssSelector("button.vjs-play-control.vjs-control.vjs-button.vjs-paused"));



    public static void waitAboutUsPlayerIsLoaded() {
        title.shouldBe(visible);
    }

    public static void clickCloseButton() {
        closeButton.click();
        title.should(disappear);
    }

    public static void clickGetPlayerButton() {
        getPlayerButton.click();
        videoPlayer.shouldBe(visible).shouldHave(Condition.attribute("src", "blob:https://demoblaze.com/dfea463a-4dcb-4ba8-be1d-a7b2fc63e1d2"));
    }

    public static void clickByPlayerWindow() {
        videoPlayer.click();
    }
}
