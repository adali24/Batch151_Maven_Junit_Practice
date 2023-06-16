package day05_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C01_Iframe extends TestBase {
    @Test
    public void name() throws InterruptedException {
// https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz

        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(iframe);


        /*
        play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı.
        Bunun üzerine HTML kodlarını inceleyince Play'in aslında bir iframe icerisinde oldugunu gördük
        Bu durumda önce iframe locate edip sonra switchTo() ile iframe'e gecmeliyiz
         */

        WebElement playTusu = driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playTusu.click();

        // videoyu durdurunuz
        WebElement pause =driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']"));
        pause.click();
        Thread.sleep(2000);

        // videoyu tam ekran yapınız
        WebElement tamEkan =driver.findElement(By.xpath("//*[@class='ytp-fullscreen-button ytp-button']"));
        tamEkan.click();
        Thread.sleep(2000);

        // videoyu calıstırınız
        pause.click();
        Thread.sleep(2000);

        // videoyu kucultunuz
        tamEkan.click();
       // WebElement tamEkandanCik =driver.findElement(By.xpath("//*[@class='ytp-fullscreen-button ytp-button']"));
       // tamEkandanCik.click();

        Thread.sleep(2000);

        // videoyu durdurunuz
        pause.click();


        // Videoyu calistirdiginizi test ediniz
       WebElement videoCalisiyormu= driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(videoCalisiyormu.isDisplayed());

        // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement yaziGorunuyormu = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(yaziGorunuyormu.isDisplayed());


    }
}