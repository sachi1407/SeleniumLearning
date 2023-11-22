package org.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommand {

    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://thetestingacademy.com");
        driver.navigate().to("https://app.vwo.com/#/login");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();

    }
}
