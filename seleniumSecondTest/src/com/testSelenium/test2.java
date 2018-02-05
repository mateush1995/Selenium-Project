package com.testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class test2 {

    static String drivePath = "F:/Selenium/";
    public WebDriver driver;
    public WebElement element;
    public JavascriptExecutor js;
    public String text1 = "Success - Check box is checked";


    @BeforeClass
    public void setUp(){
        System.out.println("**********************");
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver", drivePath+"chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    @Test
    public void CheckboxDemoTest1() throws InterruptedException {
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        element = driver.findElement(By.id("isAgeSelected"));
        element.click();

        element = driver.findElement(By.xpath("//div[contains(text(),'Success')]"));


        Assert.assertEquals(element.getText(), text1);

        Thread.sleep(3000);
    }

    @Test
    public void CheckboxDemoTest2() throws InterruptedException {
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        js.executeScript("window.scroll(0, 800)");
        element = driver.findElement(By.id("check1"));
        element.click();
        element = driver.findElement(By.xpath("//label[text()='Option 1']"));
        element.click();
        element = driver.findElement(By.xpath("//label[text()='Option 3']"));
        element.click();

        element = driver.findElement(By.id("isChkd"));

        Assert.assertEquals(element.isEnabled(), true);

        Thread.sleep(3000);
    }

    @Test
    public void RadiobuttonTest1() throws InterruptedException {
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        element = driver.findElement(By.xpath("//input[@value='Female' and @name='optradio']"));
        element.click();

        element = driver.findElement(By.id("buttoncheck"));
        element.click();

        element = driver.findElement(By.xpath("//p[@class='radiobutton']"));

        String textRadioButton = "Radio button 'Female' is checked";

        Assert.assertEquals(element.getText(), textRadioButton);

        Thread.sleep(2000);
    }

    @Test
    public void RadiobuttonTest2() throws InterruptedException{
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        js.executeScript("window.scroll(0, 800)");

        element = driver.findElement(By.xpath("//input[@value='Male' and @name='gender']"));
        element.click();
        element = driver.findElement(By.xpath("//input[@value='5 - 15' and @name='ageGroup']"));
        element.click();

        element = driver.findElement(By.xpath("//button[@class='btn btn-default' and @onclick='getValues();']"));
        element.click();
        String text = "Sex : Male\nAge group: 5 - 15";


        element = driver.findElement(By.xpath("//p[@class='groupradiobutton']"));

        Assert.assertEquals(element.getText(), text);


        Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown(){
        if(driver!=null){
            System.out.println("Closing chrome browser");
            driver.quit();
        }
    }
}
