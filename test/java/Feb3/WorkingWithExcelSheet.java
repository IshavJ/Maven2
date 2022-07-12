package Feb3;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WorkingWithExcelSheet {
    public static int row,column;
    public static String x;
    public static void main(String args[]) throws IOException {
//        System.getProperty("user.dir") +
        FileInputStream f = new FileInputStream( System.getProperty("user.dir") +"//src//test//java//Feb3//tstdta.xlsx");
        XSSFWorkbook w = new XSSFWorkbook(f);
        XSSFSheet s = w.getSheetAt(0);
        System.out.println(row = s.getLastRowNum());
        System.out.println(column = s.getRow(1).getLastCellNum());
        System.out.println(x = s.getRow(1).getCell(1).toString());
//        for(int i=1;i<=row;i++){
//            for(int j=0;j<=column-1;j++){
//                System.out.println(s.getRow(i).getCell(j).getStringCellValue());
//            }
//        }
        //Adding the data to the file....
        s.getRow(1).getCell(0).setCellValue("Harry");
        s.getRow(1).getCell(1).setCellValue(12000);
        FileOutputStream op = new FileOutputStream(System.getProperty("user.dir") +"//src//test//java//Feb3//tstdta.xlsx");
        w.write(op);
        op.close();
    }
}
