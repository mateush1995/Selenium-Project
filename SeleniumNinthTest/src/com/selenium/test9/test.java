package com.selenium.test9;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class test {

    static String drivePath = "F:/Selenium/";
    public WebDriver driver;
    public WebElement element;
    public JavascriptExecutor js;
    public String text = "Showing 1 to 3 of 3 entries (filtered from 32 total entries)";

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
    public void tableSortAndSearchDemoTest() throws InterruptedException {
        driver.navigate().to("http://www.seleniumeasy.com/test/table-sort-search-demo.html");
        Select select = new Select(driver.findElement(By.xpath("//select[@name='example_length']")));
        select.selectByValue("25");
        element = driver.findElement(By.xpath("//input[@type='search']"));
        element.sendKeys("Software");

        element = driver.findElement(By.id("example_info"));
        Assert.assertEquals(element.getText(), text);
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
