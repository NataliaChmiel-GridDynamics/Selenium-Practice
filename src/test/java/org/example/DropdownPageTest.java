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
public class DropdownPageTest {

    private String testUrl;
    private ChromeDriver driver;

    @BeforeAll
    void openBrowser() {
        testUrl = "https://bonigarcia.dev/selenium-webdriver-java/";

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(testUrl);

        driver.findElement(By.partialLinkText("Dropdown menu")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html", driver.getCurrentUrl());

        //Left-click
        driver.findElement(By.id("my-dropdown-1")).click();
        driver.findElement(By.partialLinkText("Action")).click();

        //Right-click
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.id("my-dropdown-2"));
        action.contextClick(element).perform();
        driver.findElement(By.partialLinkText("Another action")).click();

        //Double click
        WebElement btnElement = driver.findElement(By.id("my-dropdown-3"));
        action.doubleClick(btnElement).perform();
        driver.findElement(By.partialLinkText("Something else here")).click();
    }

    @Test
    void testPage() throws Exception {
        Thread.sleep(30*10_000);
    }
}

