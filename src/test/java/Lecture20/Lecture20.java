package Lecture20;

import Lecture20.entity.request.UserRequest;
import Lecture20.entity.response.UserResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class Lecture20 {

    @BeforeTest
    public void precondition() {
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void get_test() {
        Integer id = 2;
        Response response = given().get("/users?id=" + id);
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(response.then().extract().response().jsonPath().getInt("data.id"), id);
        Assert.assertEquals(response.then().extract().response().statusCode(), 200);
    }

    @Test
    public void post_test1() {
        String body = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = given().header("Content-Type", "application/json").body(body).post("/users");
        response.then().assertThat().statusCode(201);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("name"), "morpheus");
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("job"), "leader");
    }


    @Test
    public void post_test2() {
        Response response = given().header("Content-Type", "application/json").body(getJsonData("lecture20")).post("/users");
        response.then().assertThat().statusCode(201);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("name"), "morpheus");
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("job"), "leader");
    }

    @Test
    public void post_test3() {
        UserRequest user = new UserRequest() {{
            setName("morpheus");
            setJob("leader");
        }};
        Response response = given().header("Content-Type", "application/json").body(user).post("/users");
        response.then().assertThat().statusCode(201);
        UserResponse userResponse = response.as(UserResponse.class);
        Assert.assertEquals(userResponse.getName(), "morpheus");
        Assert.assertEquals(userResponse.getJob(), "leader");
    }

    @Test
    public void get_userList_Test() {
        Response response = given().get("/users?page=2");
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body(matchesJsonSchema(getJsonData("lecture20_schema")));
    }


    public String getJsonData(String filename) {
        try {
            return new String(Files.readAllBytes(Paths.get("files/" + filename + ".json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
