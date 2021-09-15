import API_Module.RequestModule.Pet_ApiActions;
import Utility_Module.PropertyFile_Reader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {

    Pet_ApiActions pet_apiActions;;
    PropertyFile_Reader defaultProperties;
    PropertyFile_Reader apiEndPoints;
    String baseUrl= new String();
    String baseUrl_Stage = new String();;

    @BeforeTest
    public void beforeTest(){
        pet_apiActions = new Pet_ApiActions();
        defaultProperties = new PropertyFile_Reader("DefaultConfig.properties");
        apiEndPoints = new PropertyFile_Reader("apiEndpoints.properties");
        baseUrl = defaultProperties.getValueFromDefaultPropertyFile("BaseUrl");
        baseUrl_Stage =  defaultProperties.getValueFromDefaultPropertyFile("BaseUrl_Stage");
    }
}
