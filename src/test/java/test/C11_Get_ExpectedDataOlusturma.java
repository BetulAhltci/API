package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C11_Get_ExpectedDataOlusturma {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine
    bir GET request yolladigimizda donen response body’sinin
    asagida verilen ile ayni oldugunu test ediniz
   Response body :
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */

    @Test
    public void get01(){
        //1-URL hazırla
        String url="https://jsonplaceholder.typicode.com/posts/22";

        //2-Expected data hazırla
        JSONObject exBody=new JSONObject();
        exBody.put("userId",3);
        exBody.put("id",22);
        exBody.put("title","dolor sint quo a velit explicabo quia nam");
        exBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        //3-Response kaydet
        Response response=given().when().get(url);
        response.prettyPrint();

        //4-Assertion yap
        //NOT: Donen response'ın body siile işlem yapmak itiyorsak bunu JsonPath objesine donusturmek gerekir

        JsonPath resJSPath=response.jsonPath();
        assertEquals(exBody.get("userId"),resJSPath.get("userId"));
        assertEquals(exBody.get("id"),resJSPath.get("id"));
        assertEquals(exBody.get("title"),resJSPath.get("title"));
        assertEquals(exBody.get("body"),resJSPath.get("body"));












    }
}
