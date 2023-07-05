package day09_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReadExcel {
    @Test
    public void test() throws IOException {
        //Ulkeler dosyasindaki tum datalari Map'e aliniz ve yazdiriniz
        Map<String,String> ulkelerMap = new TreeMap<>();
        String dosyaYou = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYou);
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirIdx = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <=sonSatirIdx ; i++) {
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            String value= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+","
            + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+","
            + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);
            System.out.println(key+ " <> "+value);

        }
       // System.out.println(ulkelerMap);
    }
}
