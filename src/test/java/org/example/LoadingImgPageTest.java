package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoadingImgPageTest extends SeleniumTest {

    @Test
    void testPage() throws Exception {
        driver.findElement(By.partialLinkText("Loading images")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html", driver.getCurrentUrl());

        //Waiting for spinner to be invisible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement spinner = driver.findElement(By.id("spinner"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));

        //Checking if images are visible
        driver.findElement(By.id("compass")).isDisplayed();
        driver.findElement(By.id("calendar")).isDisplayed();
        driver.findElement(By.id("award")).isDisplayed();
        driver.findElement(By.id("landscape")).isDisplayed();
    }
}

