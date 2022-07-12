package Feb7.post_Api_excel;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
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

public class post_serialization {
    public XSSFWorkbook w;
    public XSSFSheet s;
    public FileInputStream f;
    public FileOutputStream op;
    public String name,job,result,res1,res;
    public HashMap hm = new HashMap();
    public pojo p;
    public JsonPath j;

    @BeforeSuite
    public void setup(){
        RestAssured.basePath="/api/users";
        RestAssured.baseURI="https://reqres.in/";
    }

    @BeforeSuite
    public void excel() throws IOException {
        f = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Feb7\\emp_data.xlsx");
        w =new XSSFWorkbook(f);
        s= w.getSheetAt(0);
        //System.out.println(s.getRow(1).getCell(1).toString());
        name = s.getRow(1).getCell(1).toString();
        job=s.getRow(1).getCell(2).toString();
        p = new pojo(name,job);
        System.out.println("Done with the loading part ..");
    }

    @Test(priority = 1)
    public void post() throws FileNotFoundException {
        Response resp = given().contentType("application/json").body(p).when().post().then().statusCode(201).extract().response();
        result=resp.asString();
        System.out.println(result);
        System.out.println("Done with the testing part...");
    }

    @Test(priority = 2)
    public void add() throws IOException {
        res = given().contentType("application/json").body(p).when().post().then().statusCode(201).extract().path("id");
        s.getRow(1).getCell(0).setCellValue(res);
        op = new FileOutputStream(System.getProperty("user.dir")+"//src//test//java//Feb7//emp_data.xlsx");
        w.write(op);
        op.close();
        System.out.println("Done with the adding part");
    }
}
