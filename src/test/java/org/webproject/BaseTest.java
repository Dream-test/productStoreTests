package org.webproject;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeAll
    public static void setUpAll() {
        baseUrl = "https://demoblaze.com";
        Configuration.browserSize = "1366x768";
        Configuration.headless = true;
        Configuration.timeout = 10000;
        if (baseUrl == null || baseUrl == "") {
            logger.info("Base URL is empty");
        }
        open(baseUrl);
    }

    @BeforeEach
    public void setUpClearBrowser() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        sessionStorage().clear();
        refresh();
    }

    @AfterAll
    public static void tearDownAll() {
        closeWebDriver();
    }
}
