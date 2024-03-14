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
import org.openqa.selenium.support.ui.Select;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DragDropPageTest {

    private String testUrl;
    private ChromeDriver driver;

    @BeforeAll
    void openBrowser() {
        testUrl = "https://bonigarcia.dev/selenium-webdriver-java/";

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(testUrl);

        driver.findElement(By.partialLinkText("Drag and drop")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html", driver.getCurrentUrl());

        Actions action = new Actions(driver);

        //Drag and Drop
        WebElement sourceLocator = driver.findElement(By.id("draggable"));
        WebElement destinationLocator = driver.findElement(By.id("target"));
        action.dragAndDrop(sourceLocator, destinationLocator).build().perform();
    }

    @Test
    void testPage() throws Exception {
        Thread.sleep(30*10_000);
    }
}
