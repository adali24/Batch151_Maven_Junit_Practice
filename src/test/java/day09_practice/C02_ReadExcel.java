package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {

        // Ulkeler dosyasındaki "Başkent (İngilizce)" sutununu yazdırınız.

        String dosyaYou = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYou);
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirIdx =workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <= sonSatirIdx; i++) {
          String satirdakiData=  C01_ReadExcel.banaDataGetir(i,1);
            System.out.println(satirdakiData);

        }


    }
}
