package org.webproject.PageElements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ItemElements {
    SelenideElement item;

    public ItemElements(SelenideElement item) {
        this.item = item;
    }

    public String getProductName() {
        return item.find(By.xpath("./div/div/h4/a")).getText();
    }
}
