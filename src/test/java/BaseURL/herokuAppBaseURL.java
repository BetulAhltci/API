package BaseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class herokuAppBaseURL {
    //https://restful-booker.herokuapp.com

    protected RequestSpecification specHerokuApp;


    @Before
    public void sethup(){
        specHerokuApp=new RequestSpecBuilder()
                        .setBaseUri("https://restful-booker.herokuapp.com")
                        .build();
    }
}
