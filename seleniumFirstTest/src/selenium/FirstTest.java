package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;

public class FirstTest {

    static String driverPath = "F:/Selenium/";
    public WebDriver driver;
    public WebElement element;
    public JavascriptExecutor js;
    public String text = "Example";
    public int x = 2;
    public int y = 3;

    @BeforeClass
    public void setUp() {
        System.out.println("*******************");
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    @Test
    public void testFirst() throws InterruptedException {
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
        element = driver.findElement(By.id("user-message"));
        element.sendKeys(text);
        element = driver.findElement(By.xpath("//button[@type='button' and @onclick='showInput();']"));
        element.click();
        element = driver.findElement(By.id("display"));

        Assert.assertEquals(element.getText(), text);

        Thread.sleep(3000);

    }

    @Test
    public void testSecond() throws InterruptedException{
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
        js.executeScript("window.scrollBy(0, 1000)");
        element = driver.findElement(By.id("sum1"));
        element.sendKeys(String.valueOf(x));
        element = driver.findElement(By.id("sum2"));
        element.sendKeys(String.valueOf(y));
        element = driver.findElement(By.xpath("//button[@type='button' and @onclick='return total()']"));
        element.click();
        element = driver.findElement(By.xpath("//span[@id='displayvalue']"));

        Assert.assertEquals(element.getText(), String.valueOf(x + y));

        Thread.sleep(3000);

    }

    @AfterClass
    public void tearDown() {
        if(driver!=null) {
            System.out.println("Closing chrome browser");
            driver.quit();
        }
    }

}