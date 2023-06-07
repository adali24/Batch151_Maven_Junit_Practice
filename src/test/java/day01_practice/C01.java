package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {
    // https://ebay.com sayfasına gidiniz
    // electronics bolumune tıklayınız
    // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }



    @Test
    public void name() throws InterruptedException {
        driver.get("https://www.ebay.com");
        driver.findElement(By.xpath("(//*[.='Electronics'])[3]")).click();

        List<WebElement> image= driver.findElements(By.xpath("//*[@width='225' and @height= '225']"));
        for (int i = 0; i < image.size() ; i++) {
            image = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            image.get(i).click();
            Thread.sleep(1000);
            String title = driver.getTitle();
            System.out.println("sayfa basligi" + title);
            driver.navigate().back();
        }


    }
    @After
    public void tearDown() throws Exception {
        driver.close();

    }
}
