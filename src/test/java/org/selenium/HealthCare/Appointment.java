package org.selenium.HealthCare;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Appointment {

    WebDriver driver;

    @Owner("Sachin")
    @Description("Tc01:Verify the appointment")
    @Severity(SeverityLevel.CRITICAL)

    @BeforeMethod

    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }

    @Test

    public void makeAppointment() throws InterruptedException {
        driver.findElement(By.id("btn-make-appointment")).click();
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");

        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");

        driver.findElement(By.id("btn-login")).click();

        Thread.sleep(10000);

        WebElement element = driver.findElement(By.id("combo_facility"));
        Select sel = new Select(element);
        sel.selectByVisibleText("Hongkong CURA Healthcare Center");
        driver.findElement(By.id("chk_hospotal_readmission")).click();
        driver.findElement(By.id("radio_program_medicare")).click();
        driver.findElement(By.id("txt_visit_date")).sendKeys("14-07-1989");
        driver.findElement(By.id("btn-book-appointment")).click();
        WebElement al = driver.findElement(By.xpath("//h2[text()='Appointment Confirmation']"));
        System.out.println(al.getText());
        WebElement web = driver.findElement(By.id("facility"));
        System.out.println(web.getText());
        WebElement webb = driver.findElement(By.id("hospital_readmission"));
        System.out.println(webb.getText());
        WebElement webbb = driver.findElement(By.id("program"));
        System.out.println(webbb.getText());
        WebElement webbbb = driver.findElement(By.id("visit_date"));
        System.out.println(webbbb.getText());


    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
