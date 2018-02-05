package com.selenium.test10;

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

    @BeforeClass
    public void setUp(){
        System.out.println("**********************");
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver", drivePath+"chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void jQueryDownloadProgressBarDemoTest() throws InterruptedException {
        driver.navigate().to("http://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
        element = driver.findElement(By.id("downloadButton"));
        element.click();
        Thread.sleep(10000);

        element = driver.findElement(By.xpath("//div[@id='dialog']/div[@class='progress-label' and contains(text(), 'Complete!')]"));
        Assert.assertEquals(element.getText(), "Complete!");
        element = driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button[@type='button']"));
        element.click();
        Thread.sleep(1000);
    }

    @AfterTest
    public void tearDown(){
        if(driver!=null){
            System.out.println("Closing chrome browser");
            driver.close();
        }
    }
}
