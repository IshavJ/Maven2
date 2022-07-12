package mar24;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class apiTesting {

    public static void post(serialization p){
        Response r = given().contentType("application/json").body(p).
                when().post().then().extract().response();

        String result = r.getBody().asString();
        System.out.println(result);
    }

    public static void main(String args[]){
        //Setup
        RestAssured.basePath = "/api/users";
        RestAssured.baseURI = "https://reqres.in";

        //Calling serialization class
        serialization s = new serialization("Ishav","Tester");
        serialization p = new serialization("Jerry","Tester");

        //Main
        post(s);
        post(p);
    }
}
