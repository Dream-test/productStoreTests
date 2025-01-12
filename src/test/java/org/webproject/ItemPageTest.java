package org.webproject;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.webproject.PageElements.ItemElements;
import org.webproject.Pages.ItemPage;
import org.webproject.Pages.ProductPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemPageTest extends BaseTest {

    @Test
    @Tag( "Smoke")
    void itemNameTest() {
        //Arrange
        SelenideElement item = ProductPage.itemCard.first();
        ItemElements currentItem = new ItemElements(item);
        String productName = currentItem.getProductName();

        //Act
        currentItem.getItemCard();
        ItemPage currentItemPage = new ItemPage();
        currentItemPage.waitItemPageIsLoaded();

        //Assert
        assertEquals(productName, currentItemPage.getItemName());

    }
}
