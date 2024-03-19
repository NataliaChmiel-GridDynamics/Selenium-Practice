package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class DialogBoxesPageTest extends SeleniumTest {
    @Test
    void testPage() throws Exception {
        driver.findElement(By.partialLinkText("Dialog boxes")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html", driver.getCurrentUrl());

        //Launch alert
        driver.findElement(By.id("my-alert")).click();
        driver.switchTo().alert().accept();

        //Launch confirm
        driver.findElement(By.id("my-confirm")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirm-text")).isDisplayed();

        //Launch prompt
        driver.findElement(By.id("my-prompt")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Natalia");
        alert.accept();
        driver.findElement(By.id("prompt-text")).isDisplayed();

        //Launch modal
        driver.findElement(By.id("my-modal")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"example-modal\"]/div/div/div[3]/button[2]")).click();
        driver.findElement(By.id("modal-text")).isDisplayed();
    }
}
