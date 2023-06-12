package day03_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CheckBox {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @Test
    public void test() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/radio.html");

        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(iframe);
        //Cerezleri kapatma
        driver.findElement(By.xpath("(//div[@class='action-wrapper'])[3]")).click();
        // Ana sayfaya geri dönme
        driver.switchTo().defaultContent();


        // checkbox elementlerini locate edin
        WebElement checkBox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        WebElement checkBox3 = driver.findElement(By.xpath("(//*[@type='checkbox'])[3]"));

        // checkbox1 ve checkbox3  secili degil ise secin
        if (!checkBox1.isSelected() && !checkBox3.isSelected()){
            checkBox1.click();
            checkBox3.click();
        }

// checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox3.isSelected());

// checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(checkBox2.isSelected());






    }

    @After
    public void tearDown() throws Exception {
        //  driver.close();

    }
}
