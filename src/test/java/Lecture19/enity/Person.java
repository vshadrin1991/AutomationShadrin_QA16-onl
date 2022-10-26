package Lecture19.enity;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    Integer id;
    String name;
    Integer age;
    Boolean work;
    String country;
    String sex;
    List<String> cars;
    List<Children> children;
    Wife wife;
}