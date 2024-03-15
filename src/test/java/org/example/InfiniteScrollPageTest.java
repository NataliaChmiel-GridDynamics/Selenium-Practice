package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.Instant;


public class InfiniteScrollPageTest extends SeleniumTest {
    @Test
    void testPage() throws Exception {

        driver.findElement(By.partialLinkText("Infinite scroll")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html", driver.getCurrentUrl());

        Actions actions = new Actions(driver);
        WebElement contentPage = driver.findElement(By.id("content"));

        Instant startTime = Instant.now();

        // Scroll to the bottom of the page repeatedly for 10 seconds
        while (Duration.between(startTime, Instant.now()).getSeconds() < 5) {
            actions.sendKeys(Keys.END).perform();
        }

        driver.quit();
    }
}


