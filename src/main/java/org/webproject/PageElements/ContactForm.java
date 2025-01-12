package org.webproject.PageElements;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ContactForm {
    private final SelenideElement contactFormTitle = $(By.cssSelector("h5#exampleModalLabel"));
    private final SelenideElement emailInput = $(By.cssSelector("input#recipient-email"));
    private final SelenideElement nameInput = $(By.cssSelector("input#recipient-name"));
    private final SelenideElement messageInput = $(By.cssSelector("textarea#message-text"));
    private final SelenideElement closeFormButton = $(Selectors.byTagAndText("button", "Close"));
    private final SelenideElement sendMessageButton = $(Selectors.byTagAndText("button", "Send message"));
    private String message;
    private String email;

    public void waitContactFormIsLoaded() {
        contactFormTitle.shouldBe(visible);
    }

    public void fillContactForm(String email, String name, String message) {
        this.email = email;
        this.message = message;
        emailInput.setValue(email);
        nameInput.setValue(name);
        messageInput.setValue(message);
    }

    public void clickCloseFormButton() {
        closeFormButton.click();
        contactFormTitle.should(disappear);
    }

    public void clickSendMessageButton() {
        sendMessageButton.click();
        System.out.println("Check email: " + email + " got message: " + message);
        contactFormTitle.should(disappear);
    }


}
