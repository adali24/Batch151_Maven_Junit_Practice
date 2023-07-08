package day11_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_ScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {

        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama kutusuna Nutella yazip aratın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nutella", Keys.ENTER);


        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();

        // tüm sayfanın fotografını cekin


        String dosyaYolu = "target/ekranGoruntusu/Nutella.jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

    }
}
