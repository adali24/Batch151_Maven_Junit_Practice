package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {



    WebDriver driver;


    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

        @Test
        public void name() throws InterruptedException {
            // https://www.techproeducation.com/ sayfasina gidin
            driver.get("https://www.techproeducation.com/");

            // Title'in "Techpro" kelimesini içerip içermedigini test edin
            String techProEducationTitle = driver.getTitle();
            System.out.println("Techpro Title = " + techProEducationTitle);

            // Url'in "techproeducation" kelimesini içerip içermedigini test edin
             String techProEducationUrl= driver.getCurrentUrl();
            System.out.println("URL = "  +techProEducationUrl);
            Assert.assertTrue(techProEducationUrl.contains("techproeducation"));

            // https://www.amazon.com/ sayfasına gidin
            driver.get("https://www.amazon.com/");

            // Title'ini alın ve yazdırın
            String amazonTitle = driver.getTitle();
            System.out.println("Amazon Title = " + amazonTitle);

            // Title'in "more" kelimesini içerip içermedigini test edin
            Assert.assertTrue(amazonTitle.contains("more"));

            // techproeducation.com'a geri dönün
            driver.navigate().back();
            Thread.sleep(1500);
            // sayfayı yenileyin
            driver.navigate().refresh();
            Thread.sleep(1500);


            // amazon.com'a tekrar gelin
            driver.navigate().forward();


        }



    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
