package org.webproject;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.webproject.PageElements.ContactForm;
import org.webproject.PageElements.ItemElements;
import org.webproject.PageElements.NavBarElements;
import org.webproject.Pages.ProductPage;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ProductPageTest extends BaseTest {

    @Test
    @DisplayName("Check URL")
    void checkUrl() {
        webdriver().shouldHave(url("https://demoblaze.com"));
    }

    @Test
    @DisplayName("Check name of first product card on the page")
    void firstProductName() {
        SelenideElement firstItem = ProductPage.itemCard.first();
        String productName = new ItemElements(firstItem).getProductName();
        Assertions.assertEquals("Samsung galaxy s6", productName);
        System.out.println("First product on page: " + productName);
    }

    @Test
    @DisplayName("Check name of first product card on the next page")
    void nextPageFirstProductName() {
        ProductPage.nextButton.click();
        ProductPage.nextButton.should(disappear);
        SelenideElement firstItem = ProductPage.itemCard.first();
        String productName = new ItemElements(firstItem).getProductName();
        Assertions.assertEquals("Apple monitor 24", productName);
        System.out.println("First product onSecond page: " + productName);
        ProductPage.previousButton.click();
        ProductPage.nextButton.shouldBe(visible);
    }

    @Test
    @DisplayName("Check contact form is visible")
    void getContactForm() {
        NavBarElements.clickContactButton();
        ContactForm form = new ContactForm();
        form.waitContactFormIsLoaded();
        form.clickCloseFormButton();
    }

    @Test
    @DisplayName("Fill and send contact form")
    @Tag("Integration")
    void fillAndSendContactForm() {
        String email = "test_email@example.com";
        String name = "test_name";
        String message = "test_message";
        NavBarElements.clickContactButton();
        ContactForm form = new ContactForm();
        form.waitContactFormIsLoaded();
        form.fillContactForm(email, name, message);
        form.clickSendMessageButton();
    }



}
