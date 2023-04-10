package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C07_Get_BodyTekrarlardanKurtulma {
/*
                https://restful-booker.herokuapp.com/booking/14018 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"Jim",
                    ve "lastname“in, "Wilson",
                    ve "totalprice“in, ,
                    ve "depositpaid“in,true,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */

    @Test
    public void get01(){
        //1- request için gereklı url hazzırla
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2-Expected data hazırla

        //3-Response kaydet
        Response response=given().when().get(url);

        //4-assertion

       /* response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Mark"),
                        "lastname",Matchers.equalTo("Jackson"),
                        "totalprice",Matchers.equalTo(233),
                        "depositpaid",Matchers.equalTo(false),
                        "additionalneeds",Matchers.equalTo("Breakfast"));*/


        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Mark"),
                        "lastname",equalTo("Jackson"),
                        "totalprice",equalTo(233),
                        "depositpaid",equalTo(false),
                        "additionalneeds",equalTo("Breakfast"));

    }

}
