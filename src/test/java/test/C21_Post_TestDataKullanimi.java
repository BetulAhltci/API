package test;

import BaseURL.herokuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.testDataHerokuApp;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_Post_TestDataKullanimi extends herokuAppBaseURL {
    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip
    bir POST request gonderdigimizde donen response’un status kodunu ve id haric
    body'sinin asagidaki gibi oldugunu test edin.
    Request body
          {
          "firstname" : "Ali",
          "lastname" : “Bak",
          "totalprice" : 500,
          "depositpaid" : false,
          "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                        },
          "additionalneeds" : "wi-fi"
           }

    }
     */

    @Test
    public void post() {
        //1-Url hazırla
        specHerokuApp.pathParam("pp1", "booking");

        testDataHerokuApp testDataHerokuApp=new testDataHerokuApp();

        JSONObject reqBody=testDataHerokuApp.reqBodyJson();

        //2-Expected data hazırla

        JSONObject expBody=testDataHerokuApp.expBodyJson();

        //3-Response kaydet

        Response response=given()
                            .spec(specHerokuApp)
                            .contentType(ContentType.JSON)
                        .when()
                            .body(reqBody.toString())
                            .post("/{pp1}");

        //4-Assertion yap

        JsonPath resJP=response.jsonPath();

        assertEquals(testDataHerokuApp.basariliStatusKod,response.getStatusCode());
        assertEquals(expBody.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
        assertEquals(expBody.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
        assertEquals(expBody.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
        assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJP.get("booking.bookingdates.checkin"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resJP.get("booking.bookingdates.checkout"));



    }



}
