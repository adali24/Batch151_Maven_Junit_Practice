package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

public class C02_WindowHandel extends TestBase {
    @Test
    public void test1() {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String sayfa1Handel = driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
        String url= driver.getCurrentUrl();
        Assert.assertTrue(url.contains("amazon"));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com ");
        String sayfa2Handel= driver.getWindowHandle();


        // 4- title'in 'Best Buy' icerdigini test edelim
        String title= driver.getTitle();
        Assert.assertTrue(title.contains("Best Buy"));

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(sayfa1Handel);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);



        // 6- arama sonuclarının 'Java' icerdigini test edelim
        String sonuc= driver.findElement(By.xpath("(//*[@class=\"a-section a-spacing-small a-spacing-top-small\"])[1]")).getText();
        System.out.println(sonuc);
        Assert.assertTrue(sonuc.contains("Java"));


        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(sayfa2Handel);


        // 8- logonun gorundugunu test edelim
         WebElement logo=  driver.findElement(By.xpath("(//*[@class=\"logo\"])[1]"));
         Assert.assertTrue(logo.isDisplayed());




    }
}
