package org.webproject.PageElements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginForm {
    private final SelenideElement loginForm = $$(By.cssSelector("div.modal-content")).get(2);
    private final SelenideElement formTitle = $(Selectors.byTagAndText("h5", "Log in"));
    private final SelenideElement usernameInput = $(By.cssSelector("input#loginusername"));
    private final SelenideElement passwordInput = $(By.cssSelector("input#loginpassword"));
    private final SelenideElement closeButton = loginForm.find(By.xpath("./div/button[1]"));
    private final SelenideElement loginButton = loginForm.find(By.xpath("./div/button[2]"));

    public void waitLoginFormIsLoaded() {
    formTitle.shouldBe(visible).shouldHave(text("Log in"));
    }

    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.setValue(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.setValue(password);
    }

    public void clickCloseButton() {
        closeButton.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clearLoginForm() {
        usernameInput.clear();
        passwordInput.clear();
    }
}
