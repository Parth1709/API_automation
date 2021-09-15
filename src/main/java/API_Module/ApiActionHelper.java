package API_Module;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.Reporter;

public class ApiActionHelper {

    public ObjectMapper objectMapper = new ObjectMapper();

    public void printResponse(String response){
        System.out.println("response"+response.toString());
    }

    public void assertStatusCode(int actualCode, int expectedCode){
        Assert.assertEquals(actualCode,expectedCode,expectedCode+ " expected code doesnt matched with actual code "+actualCode);
        Reporter.log(expectedCode+ " expected code matched with actual code "+actualCode,true);
    }

    public void assertNodeValues(String actualValue,String expectedvalue){
        Assert.assertEquals(actualValue,expectedvalue,expectedvalue+ " expected code doesnt matched with actual code "+actualValue);
        Reporter.log(expectedvalue+ " expected code matched with actual code "+actualValue,true);
    }
}
