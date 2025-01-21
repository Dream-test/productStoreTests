package org.webproject.PageElements;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;

public class ItemCardElements {
    SelenideElement item;
    private final SelenideElement itemName;
    private final SelenideElement itemPrice;
    private final SelenideElement itemDescription;
    private final SelenideElement itemImage;

    public ItemCardElements(SelenideElement item) {
        this.item = item;
        itemName = item.find(By.xpath("./div/div/h4/a"));
        itemPrice = item.find(By.xpath("./div/div/h5"));
        itemDescription = item.find(By.xpath("./div/div/p"));
        itemImage = item.find(By.xpath("./div/a/img"));


    }

    public String getProductName() {
        //return item.find(By.xpath("./div/div/h4/a")).getText();
        return itemName.getText();
    }

    public String getProductPrice() {
        return itemPrice.getText();
    }

    public String getProductDescription() {
        return itemDescription.getText();
    }

    public void getItemCardByProductName() {
      itemName.click();
      item.should(disappear);
    }

    public void cardIsDisplayed() {
        itemImage.shouldBe(visible).shouldHave(Condition.attributeMatching("src", ".*imgs/.*"));
        itemName.shouldBe(visible).shouldBe(clickable);
        itemPrice.shouldBe(visible);
        itemDescription.shouldBe(visible);
    }
}
