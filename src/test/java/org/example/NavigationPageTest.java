package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NavigationPageTest {

    private String testUrl;
    private ChromeDriver driver;

    @BeforeAll
    void openBrowser() {
        testUrl = "https://bonigarcia.dev/selenium-webdriver-java/";

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(testUrl);

        driver.findElement(By.partialLinkText("Navigation")).click();

        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/navigation1.html", driver.getCurrentUrl());

        driver.findElement(By.partialLinkText("2")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/navigation2.html", driver.getCurrentUrl());
        driver.findElement(By.partialLinkText("3")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/navigation3.html", driver.getCurrentUrl());
        driver.findElement(By.partialLinkText("3")).isEnabled();
        driver.findElement(By.partialLinkText("Previous")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/navigation2.html", driver.getCurrentUrl());
    }

    @Test
    void testPage() throws Exception {
        Thread.sleep(30*10_000);
    }
}
