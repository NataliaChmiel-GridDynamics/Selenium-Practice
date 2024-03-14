package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class DragDropPageTest extends SeleniumTest {

    @Test
    void testPage() throws Exception {
        driver.findElement(By.partialLinkText("Drag and drop")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html", driver.getCurrentUrl());

        Actions action = new Actions(driver);

        //Drag and Drop
        WebElement sourceLocator = driver.findElement(By.id("draggable"));
        WebElement destinationLocator = driver.findElement(By.id("target"));
        action.dragAndDrop(sourceLocator, destinationLocator).build().perform();
    }
}
