package day06_practice;

import net.bytebuddy.jar.asm.Handle;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandels extends TestBase {
    @Test
    public void test01() throws InterruptedException {
// 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");

        String sayfa1Handle = driver.getWindowHandle();
        Thread.sleep(2000);


        // arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.xpath("//input[@id='searchData']")).sendKeys("Oppo" + Keys.ENTER);


        Thread.sleep(2000);


        // ilk ürüne tıklayın
        WebElement ilkUrun = driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]"));
        ilkUrun.click();

        Thread.sleep(2000);

        Set<String> windowHandleSeti = driver.getWindowHandles();

        String sayfa2Handle = "";

        for (String each : windowHandleSeti) {

            if (!each.equals((sayfa1Handle))) {
                sayfa2Handle = each;
            }
        }
        System.out.println("2. sayfa HANDLE: " + sayfa2Handle);


// ilk sayfaya donun ve Title'ını yazdırın

        driver.switchTo().window(sayfa1Handle);
        System.out.println("Ilk sayfa title = " + driver.getTitle());

    }
}
