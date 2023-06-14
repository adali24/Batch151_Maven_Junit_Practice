package day04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDownMenu extends TestBase {
    @Test
    public void test() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");



        // dropdown'dan "Books" secenegini secin
        //1. adim dropdown locate edilir
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        // 2. adim select objesi olusturulur
        Select select =new Select(ddm);
        // 3. adim optionlardan bir tanesi secilir 3 farkli yolla yapilabilir
      //  select.selectByVisibleText("Books");
       // select.selectByIndex(5);
        select.selectByValue("search-alias=stripbooks-intl-ship");



        // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java",Keys.ENTER);



        // arama sonuclarinin Java icerdigini test edin
        String sonuc= driver.findElement(By.xpath("(//*[@class=\"a-section a-spacing-small a-spacing-top-small\"])[1]")).getText();
        System.out.println(sonuc);
        Assert.assertTrue(sonuc.contains("Java"));


    }
}
