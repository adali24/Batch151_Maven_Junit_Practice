package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Iframe extends TestBase {
    @Test
    public void name() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions =new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();


        // Videoyu izlemek icin Play tusuna basiniz
        WebElement video = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));

        driver.switchTo().frame(video);
        WebElement oynat = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        oynat.click();

        // Videoyu calistirdiginizi test ediniz
        WebElement youTubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazisi.isDisplayed());

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement yazi = driver.findElement(By.xpath("//*[@id=\"Powerful_but_easy_to_misuse\"]"));
        Assert.assertTrue(yazi.isDisplayed());

    }

}
