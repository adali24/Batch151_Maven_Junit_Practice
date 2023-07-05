package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel {
    @Test
    public void test() throws IOException {
        // Ulkeler dosyasındaki 0. satır index'in, 4.hücre index'ine yeni bir cell olusturalım.
        // olusturdugumuz hücreye "Nufus" yazdıralım.

        String dosyaYou = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYou);
        Workbook workbook = WorkbookFactory.create(fis);

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

        /*
        1. satir index'in 4. hucre index'ine yeni bir cell olusturun
        olusturdugunuz hucreye "15000" yazdirin
         */
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(15000);

        FileOutputStream fos= new FileOutputStream(dosyaYou);
        workbook.write(fos);



    }
}
