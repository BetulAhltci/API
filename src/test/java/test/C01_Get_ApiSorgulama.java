package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {
/*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
*/

    @Test
    public void get01() {
        //1-Gonderecegimiz request için gerekli olan url ve ihtiyac varsa Request body hazırla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2-Eger sauruda bize verilmisse expexted data hazırla

        //3-Bize donen response i actual data olarak kaydet
        Response response = given().when().get(url);
        response.prettyPrint();

        System.out.println("Status Code = " + response.getStatusCode());
        System.out.println("Content Type = " + response.getContentType());
        System.out.println("Server Header Degeri = " + response.getHeader("Server"));
        System.out.println("Status Line = " + response.getStatusLine());
        System.out.println("Response Suresi = " + response.getTime());

        //4-Expected data ile actual datayi karsılastırmammız yanı Assertion yapmak gerekir


    }










}
