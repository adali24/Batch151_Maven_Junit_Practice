package day07_practice;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase{
    @Test
    public void test01() throws InterruptedException {

// 'https://www.facebook.com' sayfasina gidiniz
        driver.get("https://www.facebook.com");

// yeni hesap olustur butonuna basin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _al65 _4jy3 _4jy1 selected _51sy']")).click();
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

// isim kutusunu locate ediniz
        WebElement isim = driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));

// geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun
        Faker faker =new Faker();
        String email =faker.internet().emailAddress();
        Actions actions =new Actions(driver);
        actions.click(isim).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("13").
                sendKeys(Keys.TAB).
                sendKeys("Mart").
                sendKeys(Keys.TAB).
                sendKeys("1998").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

    }
}
