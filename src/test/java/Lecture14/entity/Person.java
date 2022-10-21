package Lecture14.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    String firstName = "Test";
    String lastName = "Test";
    String address;
    Integer age;
    String sex;
    String id;
}
