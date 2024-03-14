package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MouseOverPageTest extends SeleniumTest {
    @Test
    void testPage() throws Exception {

        driver.findElement(By.partialLinkText("Mouse over")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html", driver.getCurrentUrl());

        //Compass
        WebElement compass = driver.findElement(By.xpath("(//img[contains(@src, 'compass.png')])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(compass).build().perform();
        driver.findElement(By.cssSelector(".lead.py-3")).getText().contains("Compass");

        //Calendar
        WebElement calendar = driver.findElement(By.xpath("(//img[contains(@src, 'calendar.png')])"));
        actions.moveToElement(calendar).build().perform();
        driver.findElement(By.cssSelector(".lead.py-3")).getText().contains("Calendar");

        //Award
        WebElement award = driver.findElement(By.xpath("(//img[contains(@src, 'award.png')])"));
        actions.moveToElement(award).build().perform();
        driver.findElement(By.cssSelector(".lead.py-3")).getText().contains("Award");

        //Landscape
        WebElement landscape = driver.findElement(By.xpath("(//img[contains(@src, 'landscape.png')])"));
        actions.moveToElement(landscape).build().perform();
        driver.findElement(By.cssSelector(".lead.py-3")).getText().contains("Landscape");
    }
}

