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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SlowCalculatorPageTest {

    private String testUrl;
    private ChromeDriver driver;

    @BeforeAll
    void openBrowser() {
        testUrl = "https://bonigarcia.dev/selenium-webdriver-java/";

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(testUrl);

        driver.findElement(By.partialLinkText("Slow calculator")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html", driver.getCurrentUrl());

        //Calculating
        driver.findElement(By.xpath("//*[@id=\"calculator\"]/div[2]/span[10]")).click();
        driver.findElement(By.xpath("//*[@id=\"calculator\"]/div[2]/span[16]")).click();
        driver.findElement(By.xpath("//*[@id=\"calculator\"]/div[2]/span[10]")).click();
        driver.findElement(By.xpath("//*[@id=\"calculator\"]/div[2]/span[15]")).click();

        //Waiting for spinner to be invisible
        //WebElement duration  = driver.findElement(By.id("delay"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));//jak się odnieść do duration?
        WebElement spinner = driver.findElement(By.id("spinner"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));

        //Seeing result
        driver.findElement(By.className("screen")).getText();




    }



    @Test
    void testPage() throws Exception {
        Thread.sleep(30*10_000);
    }
}

