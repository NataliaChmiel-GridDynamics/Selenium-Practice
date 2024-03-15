package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

public class CookiesPageTest extends SeleniumTest {
    @Test
    void testPage() throws Exception {
        driver.findElement(By.partialLinkText("Cookies")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/cookies.html", driver.getCurrentUrl());

        driver.findElement(By.id("refresh-cookies")).click();
        driver.findElement(By.id("cookies-list")).isDisplayed();

        //Add new cookie
        driver.manage().addCookie(new Cookie("place", "Warsaw"));

        //Delete newly created cookie
        driver.manage().deleteCookieNamed("place");

        //Add new cookie
        driver.manage().addCookie(new Cookie("place2", "Lublin"));

        //Delete all cookies
        driver.manage().deleteAllCookies();

        //Check if there are any cookies
        driver.findElement(By.id("cookies-list")).getText();
    }
}
