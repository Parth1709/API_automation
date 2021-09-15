package API_Module.RequestModule;

import API_Module.ApiActionHelper;
import API_Module.ResponseModule.Pet.Category;
import API_Module.ResponseModule.Pet.Pet;
import API_Module.ResponseModule.Pet.Tag;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;

public class Pet_ApiActions extends ApiActionHelper {

    public Response requestPetDetailsByTag(String url, String tags){
        try {
            return RestAssured.given().param("tags",tags).get(new URL(url)).then().extract().response();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }return null;
    }

    public Pet[] getPetObjectResponse(Response response){
        try {
            return objectMapper.readValue(response.asString(), Pet[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }return null;
    }

    public Response request_Post_PetAPI(String url,Pet pet){
        try {
            return RestAssured.given().contentType("application/json").body(pet).when().post(new URL(url)).then().extract().response();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }return null;
    }

    public Pet createPetObject(String petName,int petId,String categoryName,int categoryId,String photourl,int tagid,String tagName){
        Pet pet = new Pet();
        Category category = new Category();
        pet.setId(petId);
        pet.setName(petName);
        category.setId(categoryId);
        category.setName(categoryName);
        pet.setCategory(category);
        List<String> PhotoUrl = new ArrayList<String>();
        PhotoUrl.add(photourl);
        pet.setPhotoUrls(PhotoUrl);
        Tag tag = new Tag();
        tag.setId(tagid);
        tag.setName(tagName);
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(tag);
        pet.setTags(tags);
        return pet;
    }

    public Response request_Put_PetAPI(String url,Pet pet){
        try {
            return RestAssured.given().contentType("application/json").body(pet).when().put(new URL(url)).then().log().all().extract().response();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }return null;
    }

    public Pet getSinglePetObjectResponse(Response response){
        try {
            return objectMapper.readValue(response.asString(), Pet.class);
        } catch (IOException e) {
            e.printStackTrace();
        }return null;
    }
}
