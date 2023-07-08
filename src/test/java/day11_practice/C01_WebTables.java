package day11_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[@class='secondary-button small-link']")).click();
        driver.findElement(By.xpath("//*[@class='small-link']")).click();

        driver.findElement(By.xpath("(//*[.='Log in'])[1]")).click();

        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }

    @Test

    public void test01() {
        girisYap();
        //Email basligindaki tum elementleri(sutun) yazdiriniz


        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));

        int emailSutunNo = 0;
        for (int i = 0; i < basliklarListesi.size(); i++) {
            if (basliklarListesi.get(i).getText().equals("Email")) {
                emailSutunNo = i;
            }
        }

        List<WebElement> emailList = driver.findElements(By.xpath("//tbody//tr//td["+(emailSutunNo+1)+"]"));
        for (WebElement each : emailList) {
            System.out.println(each.getText());
        }


    }
}

