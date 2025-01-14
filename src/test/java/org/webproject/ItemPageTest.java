package org.webproject;

import com.codeborne.selenide.SelenideElement;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.webproject.PageElements.ItemCardElements;
import org.webproject.Pages.ItemPage;
import org.webproject.Pages.ProductPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemPageTest extends BaseTest {

    @Test
    @Tag("Smoke")
    void itemNameTest() {
        //Arrange
        SelenideElement item = ProductPage.itemCards.first();
        ItemCardElements currentCard = new ItemCardElements(item);
        String productName = currentCard.getProductName();

        //Act
        currentCard.getItemCardByProductName();
        ItemPage currentItemPage = new ItemPage();
        currentItemPage.waitItemPageIsLoaded();

        //Assert
        assertEquals(productName, currentItemPage.getItemName());

    }

    @Test
    @Tag("Smoke")
    void itemCardElementsIsVisible() {
        //Arrange
        SelenideElement item = ProductPage.itemCards.get(2);
        ItemCardElements currentCard = new ItemCardElements(item);

        //Act, Assert
        currentCard.cardIsDisplayed();
    }

    @Test
    @Tag("Smoke")
    void itemPriceTest() {
        //Arrange
        SelenideElement item = ProductPage.itemCards.first();
        ItemCardElements currentCard = new ItemCardElements(item);
        String itemPrice = currentCard.getProductPrice();

        //Act
        currentCard.getItemCardByProductName();
        ItemPage currentItemPage = new ItemPage();
        currentItemPage.waitItemPageIsLoaded();

        assertTrue(currentItemPage.getItemPrice().contains(itemPrice),
                "The displayed item price does not contain the expected value");
    }

}
