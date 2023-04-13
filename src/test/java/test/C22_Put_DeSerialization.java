package test;

import BaseURL.jsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_DeSerialization extends jsonPlaceHolderBaseURL {
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
    Expected Data :
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */

    @Test
    public void put01(){
        //1- Url ve body hazırla
        specJasonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();
        HashMap<String,Object> reqBody=testDataJsonPlaceHolder.reqBodyMap();


        //2-Expected data olustur
        HashMap<String,Object> expBody=testDataJsonPlaceHolder.reqBodyMap();

        //3-Response kaydet
        Response response=given()
                            .spec(specJasonPlace)
                            .contentType(ContentType.JSON)
                        .when()
                            .body(reqBody)
                            .put("/{pp1}/{pp2}");

        //4-Assertion
        //Json objesi olarak donen eriyi map e cevirdik(De-Serialization)
        HashMap<String,Object> respMap=response.as(HashMap.class);

        assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        assertEquals(expBody.get("id"),respMap.get("id"));
        assertEquals(expBody.get("title"),respMap.get("title"));
        assertEquals(expBody.get("body"),respMap.get("body"));
        assertEquals(expBody.get("userId"),respMap.get("userId"));

    }

}
