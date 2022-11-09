package Lecture23;

import Lecture19.enity.Person;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lecture23 {

    List<String> list = new ArrayList<>();
    Map<String, String> map = new HashMap<>();

    @BeforeTest
    public void preconditions() {
        list.add("Test 2");
        list.add("Test 1");
        list.add("Test 3");
        list.add("Test 3");
        list.add("Test 5");
        list.add("Test 4");

        map.put("name", "Test");
        map.put("age", "14");
        map.put("city", "Test town");
    }

    @Test
    public void createStream_Test() {
        IntStream.of(1, 2, 3, 4, 5, 6);
        Stream.of("Test 1", "Test 2", "Test 3");
        String[] array = {"Test 1", "Test 2", "Test 3"};
        Arrays.asList(array).stream();
        Arrays.stream(array);
    }

    @Test
    public void streamMethods_Test() {
        Stream<String> stream = list.stream()
                .filter(data -> data.contains("Test"))
                .map(data -> data.concat("@"))
                .sorted()
                .distinct()
                .limit(3)
                .peek(System.out::println)
                .skip(1);

        //System.out.println("findFirst result :: " + stream.findFirst().get());
        //System.out.println("findAny result :: " + stream.findAny().get());
        //System.out.println(stream.collect(Collectors.toList()));
        //System.out.println(stream.count());
        //stream.forEach(System.out::println);
        Assert.assertTrue(list.stream().anyMatch(data -> data.equals("Test 1")));
        Assert.assertTrue(list.stream().allMatch(data -> data.contains(" ")));
        Assert.assertTrue(list.stream().noneMatch(data -> data.contains("User")));
        System.out.println(list.stream().max(String::compareTo).get());
        System.out.println(list.stream().min(String::compareTo).get());
    }

    @Test
    public void streamObject_Test() {
        List<Person> personList = new ArrayList<>() {{
            add(new Person() {{
                setName("User 20");
                setAge(20);
            }});
            add(new Person() {{
                setName("User 30");
                setAge(30);
            }});
            add(new Person() {{
                setName("User 40");
                setAge(40);
            }});
            add(new Person() {{
                setName("User 50");
                setAge(50);
            }});
            add(new Person() {{
                setName("User 30");
                setAge(30);
            }});
            add(new Person() {{
                setName("User 40");
                setAge(40);
            }});
        }};
        Person p = new Person(1, "Test", 30, true, "Test", "Test", new ArrayList<>() {{
            add("audi");
        }}, null, null);
        p.setCars(new ArrayList<>() {{
            addAll(p.getCars());
            add("bmw");
        }});
        System.out.println(p);
        System.out.println(personList.stream().mapToInt(Person::getAge).sum());
    }
}
