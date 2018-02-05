package com.selenium.test8;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;

public class test {

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
    public void tableFilterDemoTest() throws InterruptedException {
        driver.navigate().to("http://www.seleniumeasy.com/test/table-records-filter-demo.html");

        element = driver.findElement(By.xpath("//button[@class='btn btn-success btn-filter']"));
        element.click();
        element = driver.findElement(By.xpath("//span[@class='pull-right pagado' and contains(text(), '(Green)')]"));
        Assert.assertEquals(element.getText(), "(Green)");
        Thread.sleep(1000);

        element = driver.findElement(By.xpath("//button[@class='btn btn-warning btn-filter']"));
        element.click();
        element = driver.findElement(By.xpath("//span[@class='pull-right pendiente' and contains(text(), '(Orange)')]"));
        Assert.assertEquals(element.getText(), "(Orange)");
        Thread.sleep(1000);

        element = driver.findElement(By.xpath("//button[@class='btn btn-danger btn-filter']"));
        element.click();
        element = driver.findElement(By.xpath("//span[@class='pull-right cancelado' and contains(text(), '(Red)')]"));
        Assert.assertEquals(element.getText(), "(Red)");
        Thread.sleep(1000);

        element = driver.findElement(By.xpath("//button[@class='btn btn-default btn-filter']"));
        element.click();
        element = driver.findElement(By.xpath("//span[@class='pull-right pagado' and contains(text(), '(Green)')]"));
        Assert.assertEquals(element.getText(), "(Green)");
        element = driver.findElement(By.xpath("//span[@class='pull-right pendiente' and contains(text(), '(Orange)')]"));
        Assert.assertEquals(element.getText(), "(Orange)");
        element = driver.findElement(By.xpath("//span[@class='pull-right cancelado' and contains(text(), '(Red)')]"));
        Assert.assertEquals(element.getText(), "(Red)");
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
