package org.webproject;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.webproject.PageElements.ItemCardElements;
import org.webproject.PageElements.NavBarElements;
import org.webproject.Pages.ItemPage;
import org.webproject.Pages.ProductPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemPageTest extends BaseTest {

    @Test
    @Tag("Smoke")
    void checkItemName() {
        //Arrange
        ProductPage.waitProductPageIsLoaded();
        SelenideElement item = ProductPage.itemCards.first();
        ItemCardElements currentCard = new ItemCardElements(item);
        String productName = currentCard.getProductName();

        //Act
        currentCard.getItemCardByProductName();
        ItemPage currentItemPage = new ItemPage();
        currentItemPage.waitItemPageIsLoaded();

        //Assert
        assertEquals(productName, currentItemPage.getItemName());
        NavBarElements.clickHomeButton();
    }

    @Test
    @Tag("Smoke")
    void itemCardElementsIsVisible() {
        //Arrange
        ProductPage.waitProductPageIsLoaded();
        SelenideElement item = ProductPage.itemCards.get(2);
        ItemCardElements currentCard = new ItemCardElements(item);

        //Act, Assert
        currentCard.cardIsDisplayed();
        NavBarElements.clickHomeButton();
    }

    @Test
    @Tag("Smoke")
    void checkItemPrice() {
        //Arrange
        ProductPage.waitProductPageIsLoaded();
        SelenideElement item = ProductPage.itemCards.first();
        ItemCardElements currentCard = new ItemCardElements(item);
        String itemPrice = currentCard.getProductPrice();

        //Act
        currentCard.getItemCardByProductName();
        ItemPage currentItemPage = new ItemPage();
        currentItemPage.waitItemPageIsLoaded();

        //Assert
        assertTrue(currentItemPage.getItemPrice().contains(itemPrice),
                "The displayed item price does not contain the expected value");
        NavBarElements.clickHomeButton();
    }
}
