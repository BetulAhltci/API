package BaseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class dummyBaseURL {

    protected RequestSpecification specDummy;

    @Before
    public void sethup(){
        specDummy =new RequestSpecBuilder()
                .setBaseUri("http://dummy.restapiexample.com")
                .build();
    }
}
