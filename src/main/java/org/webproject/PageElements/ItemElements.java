package org.webproject.PageElements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;

public class ItemElements {
    SelenideElement item;
    private final SelenideElement itemName;

    public ItemElements(SelenideElement item) {
        this.item = item;
        itemName = item.find(By.xpath("./div/div/h4/a"));
    }

    public String getProductName() {
        //return item.find(By.xpath("./div/div/h4/a")).getText();
        return itemName.getText();
    }

    public void getItemCard() {
      itemName.click();
      item.should(disappear);
    }
}
