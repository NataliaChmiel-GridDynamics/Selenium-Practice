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
public class FirstPageTest {

    private String testUrl;
    private ChromeDriver driver;

    @BeforeAll
    void openBrowser() {
        testUrl = "https://bonigarcia.dev/selenium-webdriver-java/";

        // Create a new instance of the Chrome driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        driver = new ChromeDriver();

        //maximize window
        driver.manage().window().maximize();

        // And now use this to visit myBlog
        // Alternatively the same thing can be done like this
        // driver.navigate().to(testUrl);
        // driver.findElements(By.cssSelector(".btn.btn-outline-primary.mb-2")).get(1).click();

        driver.get(testUrl);
        driver.findElement(By.cssSelector(".btn.btn-outline-primary.mb-2")).click();

        driver.findElement(By.id("my-text-id")).sendKeys("This is the text you want to input");


        driver.findElement(By.name("my-password")).sendKeys("Natalia");
        driver.findElement(By.name("my-textarea")).sendKeys("This is the text you want to input");
        driver.findElement(By.name("my-disabled")).isEnabled();
        driver.findElement(By.name("my-readonly")).getAttribute("readonly");
        Select slcValue = new Select(driver.findElement(By.className("form-select")));
        slcValue.selectByValue("1");///???

        //Submitting form
        driver.findElement(By.name("my-datalist")).sendKeys("Los Angeles" + Keys.RETURN);
        driver.findElement(By.cssSelector(".lead")).getText().contains("Received!");

        //Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/submitted-form.html?my-text=&my-password=&my-textarea=&my-readonly=Readonly+input&my-select=1&my-datalist=Los+Angeles&my-file=&my-radio=on&my-colors=%23563d7c&my-date=&my-range=5&my-hidden=", driver.getCurrentUrl());
        driver.navigate().to("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        driver.findElement(By.id("my-check-2")).click();
        driver.findElement(By.id("my-radio-2")).click();
        driver.findElement(By.cssSelector(".btn.btn-outline-primary.mt-3")).click();
        driver.findElement(By.cssSelector(".lead")).getText().contains("Received!");
        driver.navigate().to("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        //Select color
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", driver.findElement(By.name("my-colors")), "#ff0000");

        //Select date
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '01-31-2025';", driver.findElement(By.name("my-date")));

        driver.findElement(By.name("my-range")).sendKeys(Keys.ARROW_LEFT);
        driver.findElement(By.partialLinkText("Return to index")).click();

        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/index.html", driver.getCurrentUrl());















    }

    @Test
    void testPage() throws Exception {
Thread.sleep(30*10_000);
    }
}
