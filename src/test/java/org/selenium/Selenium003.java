package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium003 {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser()

    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void buttonList()
    {
        driver.get("https://app.vwo.com/#/login");
       List<WebElement> list= driver.findElements(By.tagName("button"));
        System.out.println(list);
        for(WebElement button:list)
        {
            System.out.println(button.getText());
        }
    }
}
