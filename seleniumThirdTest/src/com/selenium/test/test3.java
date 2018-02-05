package com.selenium.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.KeyEvent;


public class test3 {

    static String drivePath = "F:/Selenium/";
    public WebDriver driver;
    public WebElement element;
    public JavascriptExecutor js;


    @BeforeTest
    public void setUp(){
        System.out.println("***********************");
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver", drivePath+"chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    @Test
    public void test1SelectDropdownList() throws InterruptedException {
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        Select select = new Select(driver.findElement(By.id("select-demo")));
        select.selectByValue("Tuesday");
        String text = "Day selected :- Tuesday";

        element = driver.findElement(By.xpath("//p[@class='selected-value']"));

        Assert.assertEquals(element.getText(), text);

        Thread.sleep(2000);
    }

    @Test
    public void test2MultiSelectListDemo() throws InterruptedException, AWTException {
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        js.executeScript("window.scroll(0, 800)");
        Actions action = new Actions(driver);

        new Robot().keyPress(KeyEvent.VK_CONTROL);
        element = driver.findElement(By.xpath("//select[@name='States']/option[@value='New Jersey']"));
        element.click();
        Thread.sleep(500);
        element = driver.findElement(By.xpath("//select[@name='States']/option[@value='California']"));
        element.click();
        Thread.sleep(500);
        element = driver.findElement(By.xpath("//select[@name='States']/option[@value='Texas']"));
        element.click();
        new Robot().keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(500);


        String text1 = "First selected option is : Texas";
        String text2 = "Options selected are : Texas";

        element = driver.findElement(By.id("printMe"));
        element.click();
        element = driver.findElement(By.xpath("//p[@class='getall-selected']"));
        Assert.assertEquals(element.getText(), text1);
        Thread.sleep(1000);

        element = driver.findElement(By.id("printAll"));
        element.click();
        element = driver.findElement(By.xpath("//p[@class='getall-selected']"));
        Assert.assertEquals(element.getText(), text2);
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
