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
public class MouseOverPageTest {

    private String testUrl;
    private ChromeDriver driver;

    @BeforeAll
    void openBrowser() {
        testUrl = "https://bonigarcia.dev/selenium-webdriver-java/";

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(testUrl);

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

    @Test
    void testPage() throws Exception {
        Thread.sleep(30*10_000);
    }
}

