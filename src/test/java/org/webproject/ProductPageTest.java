package org.webproject;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webproject.PageElements.ContactForm;
import org.webproject.PageElements.ItemCardElements;
import org.webproject.PageElements.LoginForm;
import org.webproject.PageElements.NavBarElements;
import org.webproject.Pages.ProductPage;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductPageTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(ProductPageTest.class);

    @Test
    @DisplayName("Check URL")
    void checkUrl() {
        webdriver().shouldHave(url("https://demoblaze.com/"));
    }

    @Test
    @DisplayName("Check name of first product card on the page")
    void checkFirstProductName() {
        //Arrange
        ProductPage.waitProductPageIsLoaded();
        SelenideElement firstItem = ProductPage.itemCards.first();

        //Act
        String productName = new ItemCardElements(firstItem).getProductName();

        //Assert
        Assertions.assertEquals("Samsung galaxy s6", productName);
        logger.info("First product on the page: {}", productName);
    }

    @Test
    @DisplayName("Check load new items group on product page")
    @Tag("Smoke")
    void checkLoadNewItemsGroup() {
        //Arrange
        ProductPage.waitProductPageIsLoaded();
        SelenideElement firstItemFistPage = ProductPage.itemCards.first();
        String firstProductName = new ItemCardElements(firstItemFistPage).getProductName();

        //Act
        ProductPage.nextButton.click();
        ProductPage.nextButton.should(disappear);
        SelenideElement firstItemSecondPage = ProductPage.itemCards.first();
        String secondProductName = new ItemCardElements(firstItemSecondPage).getProductName();

        //Assert
        assertNotEquals(firstProductName, secondProductName);
        System.out.println("First product on First page: " + firstProductName);
        System.out.println("First product on Second page: " + secondProductName);
        ProductPage.previousButton.click();
        ProductPage.nextButton.shouldBe(visible);
    }

    @Test
    @DisplayName("Check contact form is visible")
    @Tag("Smoke")
    void getContactForm() {
        //Arrange
        ProductPage.waitProductPageIsLoaded();
        NavBarElements.clickContactButton();

        //Act
        ContactForm form = new ContactForm();

        //Assert
        form.waitContactFormIsLoaded();
        form.clickCloseFormButton();
    }

    @Test
    @DisplayName("Fill and send contact form")
    @Tag("Integration")
    void fillAndSendContactFormIfEmailIsCorrect() {
        //Arrange
        String email = "test_email@example.com";
        String name = "test_name";
        String message = "test_message";

        //Act
        ProductPage.waitProductPageIsLoaded();
        NavBarElements.clickContactButton();
        ContactForm form = new ContactForm();
        form.waitContactFormIsLoaded();
        form.fillContactForm(email, name, message);
        form.clickSendMessageButton();

        //Assert
        logger.info("Check email: {} got message: {}", email, message);
        form.contactFormTitle.should(disappear);
    }

    @ParameterizedTest
    @DisplayName("Authorization with invalid login or password")
    @Tag("Reression")
    @CsvFileSource(resources = "/invalidLoginTestData.csv", numLinesToSkip = 1)
    void userAuthorizationWithInvalidData(String login, String password) {
        //Arrange
        ProductPage.waitProductPageIsLoaded();
        NavBarElements.clickLoginButton();
        LoginForm loginForm = new LoginForm();
        loginForm.waitLoginFormIsLoaded();
        loginForm.clearLoginForm();

        //Act & Assert
        if (!(login == null || login.isBlank()) && !(password == null || password.isBlank())) {
            loginForm.enterUsername(login);
            loginForm.enterPassword(password);
            loginForm.clickLoginButton();
            String alertText = switchTo().alert().getText();
            Assertions.assertEquals("User does not exist.", alertText);
            switchTo().alert().accept();
            loginForm.clickCloseButton();
        } else if (!(login == null || login.isBlank()) && (password == null || password.isBlank())) {
            loginForm.enterUsername(login);
            loginForm.clickLoginButton();
            checkAlertText();
            loginForm.clickCloseButton();
        } else if ((login == null || login.isBlank()) && !(password == null || password.isBlank())) {
            loginForm.enterPassword(password);
            loginForm.clickLoginButton();
            checkAlertText();
            loginForm.clickCloseButton();
        } else {
            loginForm.clickLoginButton();
            checkAlertText();
            loginForm.clickCloseButton();
        }
    }

    void checkAlertText() {
        String alertText = switchTo().alert().getText();
        Assertions.assertEquals("Please fill out Username and Password.", alertText);
        switchTo().alert().accept();
    }
}
