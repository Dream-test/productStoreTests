package org.webproject.PageElements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class NavBarElements {
    public static final SelenideElement homeButton = $(Selectors.byTagAndText("a", "Home"));
    public static final SelenideElement contactButton = $(Selectors.byTagAndText("a", "Contact"));
    public static final SelenideElement aboutButton = $(Selectors.byTagAndText("a", "About us"));
    public static final SelenideElement cartButton = $(Selectors.byTagAndText("a", "Cart"));
    public static final SelenideElement loginButton = $(By.id("login2"));
    public static final SelenideElement logoutButton = $(By.id("logout2"));
    public static final SelenideElement signUpButton = $(Selectors.byTagAndText("a", "Sign up"));

    public static void clickHomeButton() {
        homeButton.click();
    }

    public static void clickContactButton() {
        contactButton.click();
        $(By.id("exampleModalLabel")).shouldBe(visible).shouldHave(text("New message"));
    }

    public static void clickAboutButton() {
        aboutButton.click();
        $(By.id("videoModalLabel")).shouldBe(visible).shouldHave(text("About us"));
    }

    public static void clickCartButton() {
        cartButton.click();
        $(Selectors.byTagAndText("h2", "Products")).shouldBe(visible);
    }

    public static void clickLoginButton() {
        loginButton.click();
        $(Selectors.byTagAndText("h5", "Log in"));
    }

    public static void clickSignUpButton() {
        signUpButton.click();
        $(Selectors.byTagAndText("h5", "Sign up"));
    }

    public static void checkAllNavbarElements() {
        homeButton.shouldBe(visible).shouldBe(clickable);
        contactButton.shouldBe(visible).shouldBe(clickable);
        aboutButton.shouldBe(visible).shouldBe(clickable);
        cartButton.shouldBe(visible).shouldBe(clickable);
        loginButton.shouldBe(visible).shouldBe(clickable);
        signUpButton.shouldBe(visible).shouldBe(clickable);
    }

}
