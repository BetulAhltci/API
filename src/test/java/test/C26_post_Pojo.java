package test;

import BaseURL.herokuAppBaseURL;
import Pojos.pojoHerokuAppBooking;
import Pojos.pojoHerokuAppBookingDates;
import Pojos.pojoHerokuAppExpBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C26_post_Pojo extends herokuAppBaseURL {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
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
                        Response Body = Expected Data
                        {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ali",
                        "lastname":"Bak",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
         */

    @Test
    public void post01(){
        //1-Url e body hazırla
        specHerokuApp.pathParam("pp1","booking");

        pojoHerokuAppBookingDates bookingDates=new pojoHerokuAppBookingDates("2021-06-01","2021-06-10");
        pojoHerokuAppBooking reqBody=new pojoHerokuAppBooking("Ali","Bak",500,false,bookingDates,"wi-fi");

        //2-Expexted data olustur
        pojoHerokuAppExpBody expBody=new pojoHerokuAppExpBody(24,reqBody);

        //3-Response kaydet
        Response response=given()
                            .spec(specHerokuApp)
                            .contentType(ContentType.JSON)
                        .when()
                            .body(reqBody)
                            .post("/{pp1}");

        //4-assertion yap
        pojoHerokuAppExpBody resPojo=response.as(pojoHerokuAppExpBody.class);
        assertEquals(expBody.getBooking().getFirstname(),
                     resPojo.getBooking().getFirstname());
        assertEquals(expBody.getBooking().getLastname(),
                     resPojo.getBooking().getLastname());
        assertEquals(expBody.getBooking().getTotalprice(),
                     resPojo.getBooking().getTotalprice());
        assertEquals(expBody.getBooking().isDepositpaid(),
                     resPojo.getBooking().isDepositpaid());
        assertEquals(expBody.getBooking().getAdditionalneeds(),
                     resPojo.getBooking().getAdditionalneeds());
        assertEquals(expBody.getBooking().getBookingdates().getCheckin(),
                     resPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expBody.getBooking().getBookingdates().getCheckout(),
                     resPojo.getBooking().getBookingdates().getCheckout());


    }
}
