package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void get0(){
        //1-Url olustur
        String url="http://dummy.restapiexample.com/api/v1/employee/3";

        //2-Expected data hazırla

        /*
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
         */

        JSONObject data=new JSONObject();
        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        JSONObject exBody=new JSONObject();
        exBody.put("status","success");
        exBody.put("data",data);
        exBody.put("message","Successfully! Record has been fetched.");

        //3-Response kaydet
        Response response=given().when().get(url);

        //4-Assertion yap
        JsonPath resoJS=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(resoJS.get("status"),exBody.get("status"));
        softAssert.assertEquals(resoJS.get("message"),exBody.get("message"));
        softAssert.assertEquals(resoJS.get("data.employee_name"),exBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(resoJS.get("data.employee_salary"),exBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(resoJS.get("data.employee_age"),exBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(resoJS.get("data.profile_image"),exBody.getJSONObject("data").get("profile_image"));

        softAssert.assertAll();




    }
}
