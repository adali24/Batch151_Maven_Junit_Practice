package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C03_ActionMoveToElement extends TestBase {
    @Test
    public void test01() {

// https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");

        String  sayfa1Handle = driver.getWindowHandle();
        System.out.println("SAYFA1HANDLE: " + sayfa1Handle);

// sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions action = new Actions(driver);
        WebElement dilLokasyon = driver.findElement(By.xpath("(//*[@class='nav-line-2'])[1]"));
        action.moveToElement(dilLokasyon).perform();


// Change country/region butonuna basiniz
        WebElement country =driver.findElement(By.xpath("(//*[text() ='Change country/region.'])[1]"));
        country.click();

// United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.xpath("//*[@id='icp-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");
        driver.findElement(By.xpath("(//*[@class='a-row a-ws-row'])[1]")).click();// turkiye opsiyonunu secmesi icin herhangi biryerin locatini alip clik diyoruz


// Go to website butonuna tiklayiniz
       driver.findElement(By.xpath("//*[@class='a-button-input']")).click();

// acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz

        Set<String> windowHandleSeti = driver.getWindowHandles();


        String sayfa2Handle="";

        for (String each:windowHandleSeti) {

            if(!each.equals((sayfa1Handle))){
                sayfa2Handle = each;
            }


        }

        System.out.println("SAYFA2HANDLE: " + sayfa2Handle);


        driver.switchTo().window(sayfa2Handle);
        String ikinciSayfaTitle = driver.getTitle();
        System.out.println(driver.getTitle());

        Assert.assertTrue(ikinciSayfaTitle.contains("Elektronik"));


    }
}
