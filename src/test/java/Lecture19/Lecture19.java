package Lecture19;

import Lecture19.enity.Person;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Lecture19 {

    //@Test
    public void jsonTest() {
        Gson gson = new Gson();
        String data = getJsonData();
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        System.out.println(gson.toJson(jsonObject));
        System.out.println(jsonObject.get("id").getAsInt());
        System.out.println(jsonObject.get("name").getAsString());
        System.out.println(gson.fromJson(jsonObject.get("cars"), List.class));
        System.out.println(gson.fromJson(jsonObject, Map.class));
        System.out.println(jsonObject.get("wife").getAsJsonObject().get("name"));
        System.out.println(jsonObject.get("children").getAsJsonArray().get(0).getAsJsonObject().get("name"));
        System.out.println(jsonObject.get("children").getAsJsonArray().get(1).getAsJsonObject().get("name"));
    }

    @Test
    public void jsonObjectTest() {
        Gson gson = new Gson();
        String data = getJsonData();
        Person person = gson.fromJson(data, Person.class);
        person.getCars().forEach(System.out::println);
        person.getChildren().forEach(children -> System.out.print(children.getName()));
    }

    public String getJsonData() {
        try {
            return new String(Files.readAllBytes(Paths.get("files/person.json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
