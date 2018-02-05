package com.Selenium.test7;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class test {

    static String drivePath = "F:/Selenium/";
    public WebDriver driver;
    public WebElement element;
    public JavascriptExecutor js;


    @BeforeTest
    public void setUp(){
        System.out.println("**********************");
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver", drivePath+"chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    @Test
    public void tableSearchFilterDemoTest() throws InterruptedException {
        driver.navigate().to("http://www.seleniumeasy.com/test/table-search-filter-demo.html");
        element = driver.findElement(By.id("task-table-filter"));
        element.sendKeys("wi");
        element = driver.findElement(By.xpath("//div[@class='panel panel-primary']/table/tbody/tr['+ 1 +']/td[contains(text(), 'John Smith')]"));
        Assert.assertEquals(element.getText(), "John Smith");

        Thread.sleep(1000);

        js.executeScript("window.scroll(0, 300)");

        element = driver.findElement(By.xpath("//button[@class='btn btn-default btn-xs btn-filter']"));
        element.click();
        element = driver.findElement(By.xpath("//input[@type='text' and @class='form-control' and @placeholder='#']"));
        element.sendKeys("4");

        element = driver.findElement(By.xpath("//div[@class='panel panel-primary filterable']/table[@class='table']/tbody/tr['+ 4 +']/td[contains(text(), 'mikesali')]"));
        Assert.assertEquals(element.getText(), "mikesali");
        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown(){
        if(driver!=null){
            System.out.println("Closing chrome browser");
            driver.quit();
        }
    }
}
