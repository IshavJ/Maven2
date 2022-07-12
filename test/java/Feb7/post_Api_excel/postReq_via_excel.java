package Feb7.post_Api_excel;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class postReq_via_excel {
    public XSSFWorkbook w;
    public XSSFSheet s;
    public FileInputStream f;
    public String name,job,result;
    public HashMap hm = new HashMap();

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
        System.out.println("Done with the loading part ..");
    }

    @Test
    public int boDy(){
        System.out.println(name);
        System.out.println(job);
        hm.put("name",name);
        hm.put("job",job);
        System.out.println(hm);
        System.out.println("Done Fetching ...");
        return 0;
    }

    @Test
    public void post(){
        Response resp =
                given().body(boDy()).when().post().then().statusCode(201)
                        .extract().response();
        result=resp.asString();
        System.out.println(result);
    }
}
