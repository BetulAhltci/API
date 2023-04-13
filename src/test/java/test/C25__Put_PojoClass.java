package test;

import BaseURL.jsonPlaceHolderBaseURL;
import Pojos.jsonPlaceHolderReqBodyPojo;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25__Put_PojoClass extends jsonPlaceHolderBaseURL {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
 body’e sahip bir PUT request yolladigimizda donen response’in
 response body’sinin asagida verilen ile ayni oldugunu test ediniz
     Request Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
    Expected Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

    @Test
    public void put01(){

        //1-URl be body hazırla
        specJasonPlace.pathParams("pp1","posts","pp2",70);
        jsonPlaceHolderReqBodyPojo reqBody=new jsonPlaceHolderReqBodyPojo("Ahmet","Merhaba",10,70);
        //System.out.printf("reqBody =" +reqBody);

        //2-Expected data hazırla
        jsonPlaceHolderReqBodyPojo expBody=new jsonPlaceHolderReqBodyPojo("Ahmet","Merhaba",10,70);

        //3-Response kaydet
        Response response=given()
                            .spec(specJasonPlace)
                            .contentType(ContentType.JSON)
                        .when()
                            .body(reqBody)
                            .put("/{pp1}/{pp2}");
        response.prettyPrint();

        //4-Assertion yap
        //JsonPath resJP=response.jsonPath();
        //Map<String,Object> resMap=response.as(HashMap.class);
        jsonPlaceHolderReqBodyPojo resPojo=response.as(jsonPlaceHolderReqBodyPojo.class);

        assertEquals(expBody.getTitle(),resPojo.getTitle());
        assertEquals(expBody.getBody(),resPojo.getBody());
        assertEquals(expBody.getId(),resPojo.getId());
        assertEquals(expBody.getUserId(),resPojo.getUserId());


    }




}
