package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class NavigationPageTest extends SeleniumTest {
    @Test
    void testPage() throws Exception {
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
}
