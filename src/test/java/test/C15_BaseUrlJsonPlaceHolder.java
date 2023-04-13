package test;

import BaseURL.jsonPlaceHolderBaseURL;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C15_BaseUrlJsonPlaceHolder extends jsonPlaceHolderBaseURL {
//Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
    /*
        1-  https://jsonplaceholder.typicode.com/posts endpointine bir GET
         request gonderdigimizde donen response’un status code’unun 200 oldugunu
         ve Response’ta 100 kayit oldugunu test edin.
        */
    /*
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET
            request gonderdigimizde donen response’un status code’unun 200 oldugunu
            ve “title” degerinin “optio dolor molestias sit” oldugunu test edin
         */
    /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
            request gonderdigimizde donen response’un status code’unun 200 oldugunu ve
            response body’sinin null oldugunu test edin
         */

    @Test
    public void get01(){
        /*
         1-  https://jsonplaceholder.typicode.com/posts endpointine bir GET
         request gonderdigimizde donen response’un status code’unun 200 oldugunu
         ve Response’ta 100 kayit oldugunu test edin.
         */

        //1-Url hazırla(Path parametreleri)
        specJasonPlace.pathParam("pp1","posts");

        //2-Expected data hazırla

        //3-Response kaydet
        Response response=given().spec(specJasonPlace).when().get("/{pp1}");
        response.prettyPeek();

        //4-Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.hasSize(100));


    }

    @Test
    public void get02(){
        /*
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET
            request gonderdigimizde donen response’un status code’unun 200 oldugunu
            ve “title” degerinin “optio dolor molestias sit” oldugunu test edin
         */

        //1-Url hazırla
        specJasonPlace.pathParams("pp1","posts","pp2",44);

        //2-Expected data hazırla

        //3-Response kaydet
        Response response=given().spec(specJasonPlace).when().get("/{pp1}/{pp2}");

        //4-Assertion yap
        response.then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));
    }

    @Test
    public void delete01(){
        /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE
            request gonderdigimizde donen response’un status code’unun 200 oldugunu ve
            response body’sinin null oldugunu test edin
         */

        //1-Url hazırla
        specJasonPlace.pathParams("pp1","posts","pp2",50);

        //2-Expected data hazırla

        //3-Respons kaydet
        Response response=given().spec(specJasonPlace).when().delete("/{pp1}/{pp2}");

        //4-Assertion
        response.then().assertThat().statusCode(200).body("body",Matchers.nullValue());

    }
}
