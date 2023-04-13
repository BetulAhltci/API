package BaseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class jsonPlaceHolderBaseURL {
    //https://jsonplaceholder.typicode.com

   protected RequestSpecification specJasonPlace;

   @Before
    public void sethup(){
       specJasonPlace=new RequestSpecBuilder()
                                    .setBaseUri("https://jsonplaceholder.typicode.com")
                                    .build();
   }
}
