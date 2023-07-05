package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {
        // Ulkeler dosyasındaki 3.satır indexin, 3.sutunundaki indexinin
        // "Cezayir" oldugunu test eden method olusturunuz.

        int satirNoIdx =3;
        int sutunNIdx = 3;

        String actuelData= banaDataGetir(satirNoIdx,sutunNIdx);
        String expectedData = "Cezayir";

        Assert.assertEquals(expectedData,actuelData);

    }

    public static String banaDataGetir(int satirNoIdx, int sutunNIdx) throws IOException {
        String dosyaYou = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYou);

        Workbook workbook = WorkbookFactory.create(fis);

        String istenenData = workbook.getSheet("Sayfa1").getRow(satirNoIdx).getCell(sutunNIdx).toString();

        return istenenData;
    }
}
