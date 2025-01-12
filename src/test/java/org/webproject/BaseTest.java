package org.webproject;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeAll
    public static void setUpAll() {
        baseUrl = "https://demoblaze.com";
        Configuration.browserSize = "1366x768";
        Configuration.headless = true;
        Configuration.timeout = 10000;
        open(baseUrl);
    }

    @BeforeEach
    public void setUpClearBrowser() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        sessionStorage().clear();
    }

    @AfterEach
    public void tearDownClearBrowser() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        sessionStorage().clear();
    }

    @AfterAll
    public static void tearDownAll() {
        closeWebDriver();
    }
}
