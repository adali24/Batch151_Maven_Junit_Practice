package day10_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    @Test
    public void test01() {
// girisYap methodu olusturun
// https://www.hotelmycamp.com adresine gidin
// Log in butonuna tıklayın
// Username: manager
// Password: Manager1!
        girisYap();

// sutun sayısını yazdırın
        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("SUTUN SAYISI : " + sutunBasliklariListesi.size());
        System.out.println("*********************************");


// tum body'i yazdirin
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        System.out.println("*********************************");

// body'de bulunan satır sayısını yazdırın
        List<WebElement> bodydeBulunanSatirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir Sayisi = " + bodydeBulunanSatirSayisi.size());
        System.out.println("*********************************");


// body'de bulunan satırları yazdırın
        for (WebElement each : bodydeBulunanSatirSayisi) {
            System.out.println(each.getText());

        }


// 4.satırdaki elementleri yazdırın
        List<WebElement> dorduncuSatirElemenleri = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        dorduncuSatirElemenleri.stream().forEach(t -> System.out.print(t.getText() + ","));

    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[@class='secondary-button small-link']")).click();
        driver.findElement(By.xpath("//*[@class='small-link']")).click();

        driver.findElement(By.xpath("(//*[.='Log in'])[1]")).click();

        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}
