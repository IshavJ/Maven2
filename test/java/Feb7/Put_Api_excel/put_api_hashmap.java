package Feb7.Put_Api_excel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class put_api_hashmap {
    public XSSFWorkbook w;
    public XSSFSheet s;
    public FileInputStream f;
    public String name,job,result, x,res;
    public HashMap hm = new HashMap();
    public Response rep;
    public FileOutputStream op;

    @BeforeSuite
    public void setup(){
        RestAssured.baseURI="https://reqres.in/";
        RestAssured.basePath="/api/users/2";
    }

    @BeforeSuite
    public void excel() throws IOException {
        f= new FileInputStream(System.getProperty("user.dir")+"//src//test//java//Feb7//emp_data.xlsx");
        w = new XSSFWorkbook(f);
        s = w.getSheetAt(0);
        name = s.getRow(2).getCell(1).toString();
        job = s.getRow(2).getCell(2).toString();
        System.out.println("Excel sheet loaded..");
    }

    @Test(priority = 1)
    public int getData(){
        System.out.println(name);
        System.out.println(job);
        hm.put("name",name);
        hm.put("job",job);
        System.out.println("Done Fetching data...");
        return 0;
    }

    @Test(priority = 2)
    public void pUt() throws IOException {
        rep = given().body(getData()).when().put().then().statusCode(200).extract().response();
        x = rep.asString();
        System.out.println(x);
    }

    @Test(priority = 3)
    public void add() throws IOException {
        res = given().body(getData()).when().put().then().extract().path("updatedAt");
        System.out.println(res);
        s.getRow(2).getCell(4).setCellValue(res);
        op = new FileOutputStream(System.getProperty("user.dir")+"//src//test//java//Feb7//emp_data.xlsx");
        w.write(op);
        op.close();
    }
}
