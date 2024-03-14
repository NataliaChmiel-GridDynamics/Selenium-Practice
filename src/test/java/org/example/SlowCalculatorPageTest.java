package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class SlowCalculatorPageTest extends SeleniumTest{

    @Test
    void testPage() throws Exception {
        driver.findElement(By.partialLinkText("Slow calculator")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html", driver.getCurrentUrl());

        //Calculating
        driver.findElement(By.xpath("//*[@id=\"calculator\"]/div[2]/span[10]")).click();
        driver.findElement(By.xpath("//*[@id=\"calculator\"]/div[2]/span[16]")).click();
        driver.findElement(By.xpath("//*[@id=\"calculator\"]/div[2]/span[10]")).click();
        driver.findElement(By.xpath("//*[@id=\"calculator\"]/div[2]/span[15]")).click();

        //
        WebElement delayElement = driver.findElement(By.id("delay"));
        int delayDuration = Integer.valueOf(delayElement.getAttribute("value"));
        //Thread.sleep(Duration.ofSeconds(delayDuration));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(delayDuration));

        //Waiting for spinner to be invisible
        WebElement spinner = driver.findElement(By.id("spinner"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));

        //Seeing result
        driver.findElement(By.className("screen")).getText();
    }
}

