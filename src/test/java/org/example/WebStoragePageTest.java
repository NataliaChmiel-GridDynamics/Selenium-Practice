package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class WebStoragePageTest extends SeleniumTest {
    @Test
    void testPage() throws Exception {
        driver.findElement(By.partialLinkText("Web storage")).click();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/web-storage.html", driver.getCurrentUrl());

        //1. Display local storage
        driver.findElement(By.id("display-local")).click();
        driver.findElement(By.id("local-storage")).isDisplayed();

        //Find local storage element
        WebElement localStoragePlace = driver.findElement(By.id("local-storage"));

        // Simulate setting data into localStorage using JavaScript
        String name = "window.localStorage.setItem('name', 'Natalia');";
        String date = "window.localStorage.setItem('date', '17/04/2024');";

        ((JavascriptExecutor) driver).executeScript(name);
        ((JavascriptExecutor) driver).executeScript(date);

        //Stored values
        String storedName = (String) ((JavascriptExecutor) driver).executeScript("return window.localStorage.getItem('name');");
        String storedDate = (String) ((JavascriptExecutor) driver).executeScript("return window.localStorage.getItem('date');");

        //Printing values
//        System.out.println("Stored name: " + storedName);
//        System.out.println("Stored date: " + storedDate);


        //2. Display session storage
        driver.findElement(By.id("display-session")).click();
        driver.findElement(By.id("session-storage")).isDisplayed();

        //Get session storage key and values
        String sessionName = "return window.sessionStorage.getItem('name');";
        String sessionLastname = "return window.sessionStorage.getItem('lastname');";

        String sessionNameData = (String) ((JavascriptExecutor) driver).executeScript(sessionName);
        String sessionLastnameData = (String) ((JavascriptExecutor) driver).executeScript(sessionLastname);
        
        // Print the retrieved data
        System.out.println("Session data: " + sessionNameData);
        System.out.println("Session data: " + sessionLastnameData);


    }
}
