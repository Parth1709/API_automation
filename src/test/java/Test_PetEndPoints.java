import API_Module.ResponseModule.Pet.Pet;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Test_PetEndPoints extends  BaseTest{

    Pet[] pets;

    @Test(description = "Pet GET API")
    public void verify_GET_UserIsAbleToFindPetByTags(){
        Response getPetResponse = pet_apiActions.requestPetDetailsByTag(baseUrl+apiEndPoints.getValueFromDefaultPropertyFile("Get_Pet_ByTags"),"Parth"); // reading the end point from file and appending it to baseurl
        pet_apiActions.printResponse(getPetResponse.asString()); //printing response on console
        pet_apiActions.assertStatusCode(getPetResponse.statusCode(),200); // assertion for status code
        pets = pet_apiActions.getPetObjectResponse(getPetResponse); // implicit assertion validation schema by creating objects
        pet_apiActions.assertNodeValues(pets[0].getName(),"doggie"); // assertion for name node
        pet_apiActions.assertNodeValues(pets[0].getTags().get(0).getName(),"Parth"); // assertion for tag node

    }

    @Test(description = "Pet POST API")
    public void verify_POST_UserIsAbleToAddANewPet(){
        Pet petObject = pet_apiActions.createPetObject("parthTest",111,"dgg",111,"String",111,"parthTest");
        Response petResponse = pet_apiActions.request_Post_PetAPI(baseUrl+apiEndPoints.getValueFromDefaultPropertyFile("Post_AddNewPet"),petObject);// reading the end point from file and appending it to baseurl
        pet_apiActions.printResponse(petResponse.asString());//printing response on console
        pet_apiActions.assertStatusCode(petResponse.statusCode(),200);// assertion for status code
    }

    @Test(description = "Pet PUT API")
    public void verify_PUT_UserIsAbleToUpdateAnExisingPet(){
        Pet petObject = pet_apiActions.createPetObject("parthTest",111,"dgg",111,"String",111,"parthTestTestTest");
        Response petResponse = pet_apiActions.request_Put_PetAPI(baseUrl+apiEndPoints.getValueFromDefaultPropertyFile("Put_AddNewPet"),petObject);// reading the end point from file and appending it to baseurl
        pet_apiActions.printResponse(petResponse.asString()); //print response
        pet_apiActions.assertStatusCode(petResponse.statusCode(),200);// assertion of status code
        Pet pet = pet_apiActions.getSinglePetObjectResponse(petResponse); // implicit assertion validation schema by creating objects
        pet_apiActions.assertNodeValues(pet.getTags().get(0).getName(),"parthTestTestTest"); // assertion for tag node

    }
}
