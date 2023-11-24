package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdown {

    WebDriver driver;

    @BeforeTest

    public void openBroswer() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
    }

    @Test

    public void testDropdown() {


        WebElement el = driver.findElement(By.id("dropdown"));
        Select sel = new Select(el);
        sel.selectByVisibleText("Option 2");

    }

    @AfterTest

    public void closeBrowser() {
        driver.quit();
    }


}
