package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DriveCanvasPageTest extends SeleniumTest {
    @Test
    void testPage() throws Exception {
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
}

