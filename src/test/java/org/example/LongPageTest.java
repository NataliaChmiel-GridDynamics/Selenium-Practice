package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;


public class LongPageTest extends SeleniumTest {
    @Test
    void testPage() throws Exception {
        driver.findElement(By.partialLinkText("Long page")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/long-page.html", driver.getCurrentUrl());

        //Checking if long page content is visible
        driver.findElement(By.id("content")).isDisplayed();

        //Scrolling to the bottom of the page
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //Checking if footer is visible
        driver.findElement(By.cssSelector(".footer.mt-auto.py-3.bg-light")).isDisplayed();
    }
}
