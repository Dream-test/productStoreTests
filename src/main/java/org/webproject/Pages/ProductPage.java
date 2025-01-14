package org.webproject.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {
    public static final SelenideElement listGroup = $(By.xpath("//a[@id='cat']"));
    public static final SelenideElement navBar = $(By.cssSelector("div.navbar-collapse#navbarExample"));
    public static final ElementsCollection itemCards = $$(By.cssSelector("div.col-lg-4.col-md-6.mb-4"));
    public static final SelenideElement previousButton = $(Selectors.byTagAndText("button", "Previous"));
    public static final SelenideElement nextButton = $(Selectors.byTagAndText("button", "Next"));

    public static void waitProductPageIsLoaded() {
        listGroup.shouldBe(visible).shouldHave(text("CATEGORIES"));
    }


}
