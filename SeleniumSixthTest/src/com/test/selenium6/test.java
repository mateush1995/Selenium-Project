package com.test.selenium6;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class test {

    static String drivePath = "F:/Selenium/";
    public WebDriver driver;
    public WebElement element;
    public String nazwa = "Jakas tam nazwa";
    public String komentarz = "Jakis tam komentarz, Jakis tam komentarz, Jakis tam komentarz, Jakis tam komentarz, ";


    @BeforeTest
    public void setUp(){
        System.out.println("************************");
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver", drivePath+"chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void AjaxFormSubmitTest() throws InterruptedException {
        driver.navigate().to("http://www.seleniumeasy.com/test/ajax-form-submit-demo.html");

        element = driver.findElement(By.id("title"));
        element.sendKeys(nazwa);

        element = driver.findElement(By.id("description"));
        element.sendKeys(komentarz);

        element = driver.findElement(By.id("btn-submit"));
        element.click();
        Thread.sleep(3000);

        element = driver.findElement(By.id("submit-control"));
        Assert.assertEquals(element.getText(), "Form submited Successfully!");
        Thread.sleep(500);
    }

    @AfterTest
    public void tearDown(){
        if(driver!=null){
            System.out.println("Closing chrome browser");
            driver.quit();
        }
    }


}
