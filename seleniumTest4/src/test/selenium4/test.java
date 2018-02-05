package test.selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class test {
    static String drivePath ="F:/Selenium/";
    public WebDriver driver;
    public WebElement element;
    public JavascriptExecutor js;

    public String imie = "Jan";
    public String nazwisko = "Kowalski";
    public String email = "jakis@mail.com";
    public String numerTelefonu ="1234567890";
    public String adres = "ulicznaa";
    public String miasto = "Warszawa";
    public String kodPocztowy = "12345";
    public String strona = "www.jakastamstrona.com";
    public String opisProjektu = "jakis tam opis projektu";


    @BeforeTest
    public void setUp(){
        System.out.println("**************************");
        System.out.println("launching chrome browser");
        System.setProperty("webdriver.chrome.driver", drivePath+"chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    @Test
    public void inputFormWithValidationTest(){
        driver.navigate().to("http://www.seleniumeasy.com/test/input-form-demo.html");

        //imie
        element = driver.findElement(By.xpath("//input[@name='first_name' and @placeholder='First Name']"));
        element.sendKeys(imie);
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='stringLength' and @data-bv-for='first_name']"));
        Assert.assertEquals(element.getText(), "");
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='notEmpty' and @data-bv-for='first_name']"));
        Assert.assertEquals(element.getText(), "");

        //nazwisko
        element = driver.findElement(By.xpath("//input[@name='last_name' and @placeholder='Last Name']"));
        element.sendKeys(nazwisko);
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='stringLength' and @data-bv-for='last_name']"));
        Assert.assertEquals(element.getText(), "");
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='notEmpty' and @data-bv-for='last_name']"));
        Assert.assertEquals(element.getText(), "");

        //e-mail
        element = driver.findElement(By.xpath("//input[@name='email' and @placeholder='E-Mail Address']"));
        element.sendKeys(email);
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='notEmpty' and @data-bv-for='email']"));
        Assert.assertEquals(element.getText(), "");
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='emailAddress' and @data-bv-for='email']"));
        Assert.assertEquals(element.getText(), "");

        //numer telefonu
        element = driver.findElement(By.xpath("//input[@name='phone' and @placeholder='(845)555-1212']"));
        element.sendKeys(numerTelefonu);
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='notEmpty' and @data-bv-for='phone']"));
        Assert.assertEquals(element.getText(), "");
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='phone' and @data-bv-for='phone']"));
        Assert.assertEquals(element.getText(), "");

        js.executeScript("window.scroll(0, 600)");

        //adres
        element = driver.findElement(By.xpath("//input[@name='address' and @placeholder='Address']"));
        element.sendKeys(adres);
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='stringLength' and @data-bv-for='address']"));
        Assert.assertEquals(element.getText(), "");
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='notEmpty' and @data-bv-for='address']"));
        Assert.assertEquals(element.getText(), "");

        //miasto
        element = driver.findElement(By.xpath("//input[@name='city' and @placeholder='city']"));
        element.sendKeys(miasto);
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='stringLength' and @data-bv-for='city']"));
        Assert.assertEquals(element.getText(), "");
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='notEmpty' and @data-bv-for='city']"));
        Assert.assertEquals(element.getText(), "");

        //stan
        Select select = new Select(driver.findElement(By.xpath("//select[@name='state']")));
        select.selectByIndex(3);
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='notEmpty' and @data-bv-for='state']"));
        Assert.assertEquals(element.getText(), "");

        //kod pocztowy
        element = driver.findElement(By.xpath("//input[@name='zip' and @placeholder='Zip Code']"));
        element.sendKeys(kodPocztowy);
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='notEmpty' and @data-bv-for='zip']"));
        Assert.assertEquals(element.getText(), "");
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='zipCode' and @data-bv-for='zip']"));
        Assert.assertEquals(element.getText(), "");

        //strona internetowa
        element = driver.findElement(By.xpath("//input[@name='website' and @placeholder='Website or domain name']"));
        element.sendKeys(strona);


        //hosting
        element = driver.findElement(By.xpath("//input[@type='radio' and @value='yes']"));
        element.click();

        //opis projektu
        element = driver.findElement(By.xpath("//textarea[@class='form-control' and @name='comment']"));
        element.sendKeys(opisProjektu);
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='stringLength' and @data-bv-for='comment']"));
        Assert.assertEquals(element.getText(), "");
        element = driver.findElement(By.xpath("//small[@class='help-block' and @data-bv-validator='notEmpty' and @data-bv-for='comment']"));
        Assert.assertEquals(element.getText(), "");

        //wyslanie formy
        element = driver.findElement(By.xpath("//button[@type='submit' and @class='btn btn-default']"));
        element.click();
    }

    @AfterTest
    public void tearDown(){
        if(driver!=null){
            System.out.println("Closing chrome browser");
            driver.quit();
        }
    }

}
