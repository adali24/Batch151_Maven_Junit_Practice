package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ActionsDragAndDrop extends TestBase {
    @Test
    public void test01() throws InterruptedException {

// https://demoqa.com/droppable adresine gidiniz
        driver.get("https://demoqa.com/droppable");

// 'Drag me' butonunu tutup 'Drop here' kutusunun ustune birakiniz
        Actions action= new Actions(driver);
       WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
       WebElement dropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));

        action.clickAndHold(dragMe).moveToElement(dropHere,20,30).perform();
Thread.sleep(3000);

// 'Drop here' yazisi yerine 'Dropped!' oldugunu test ediniz
       WebElement yaziGorunuyormu = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertEquals(yaziGorunuyormu.getText(),"Dropped!");


    }
}
