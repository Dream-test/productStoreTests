package org.webproject.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ItemPage {
    private final SelenideElement itemName = $(By.cssSelector("h2.name"));
    private final SelenideElement itemPrice = $(By.cssSelector("h3.price-container"));
    private final SelenideElement itemDescription = $(By.xpath("//*[@id='more-information']/p"));
    private final SelenideElement addToCartButton = $(By.cssSelector(".btn.btn-success.btn-lg"));

    public void waitItemPageIsLoaded() {
        $(By.cssSelector("div.product-deatil")).shouldBe(visible);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    public String getItemDescription() {
        return itemDescription.getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }
}
