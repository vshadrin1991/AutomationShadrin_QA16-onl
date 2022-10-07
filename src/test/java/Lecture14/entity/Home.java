package Lecture14.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder(builderClassName = "HomeBuilder", setterPrefix = "with", buildMethodName = "create")
public class Home {
    String doors;
    String color;
    String address;
    Integer winCount;
    Boolean old;

    public static class HomeBuilder {
        public HomeBuilder() {
        }
    }
}