package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoadingImgPageTest {

    private String testUrl;
    private ChromeDriver driver;

    @BeforeAll
    void openBrowser() {
        testUrl = "https://bonigarcia.dev/selenium-webdriver-java/";

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(testUrl);

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

    @Test
    void testPage() throws Exception {
        Thread.sleep(30*10_000);
    }
}

