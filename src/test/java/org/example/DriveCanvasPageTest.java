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
public class DriveCanvasPageTest {

    private String testUrl;
    private ChromeDriver driver;

    @BeforeAll
    void openBrowser() {
        testUrl = "https://bonigarcia.dev/selenium-webdriver-java/";

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(testUrl);

        driver.findElement(By.partialLinkText("Draw in canvas")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/draw-in-canvas.html", driver.getCurrentUrl());

        //Drawing in canvas
        Actions drawing = new Actions(driver);

        WebElement canvas = driver.findElement(By.id("my-canvas"));
        drawing.clickAndHold(canvas)
                .moveByOffset(10, 10) // Move by 10 pixels right and down
                .moveByOffset(-10, 10) // Move by 10 pixels left and down to create a square
                .moveByOffset(-10, -10) // Move by 10 pixels left and up
                .moveByOffset(10, -10) // Move by 10 pixels right and up to complete the square
                .release()
                .perform();

    }

    @Test
    void testPage() throws Exception {
        Thread.sleep(30*10_000);
    }
}

