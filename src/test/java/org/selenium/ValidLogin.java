package org.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenBrowser {
    @Test
    public void openBrowser() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://app.vwo.com/");
        driver.findElement(By.id("login-username")).sendKeys("sachinocm23@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("Sachin@1");
        driver.findElement(By.id("js-login-btn")).click();
        Thread.sleep(5000);

        driver.quit();
    }
}
