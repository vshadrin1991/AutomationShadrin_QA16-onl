package Lecture14;

import Lecture14.entity.Car;
import Lecture14.entity.Home;
import Lecture14.entity.Person;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;

@Log4j
public class Lecture14_Test {

    @Test
    public void person_Test() {
        Person person1 = new Person() {{
            setAddress("Vitebsk");
            setFirstName("Vitali");
            setLastName("Shadrin");
        }};
        Person person2 = new Person("", "", "", 0, "", "");
        log.debug(person1);
        log.debug(person2);
    }

    @Test
    public void car_Test() {
        Car car = new Car() {{
            setColor("black");
            setModel("Tesla");
            setType("Electro");
        }};
        log.debug(car.getModel());
        log.debug(car);
    }

    @Test
    public void home_Test() {
        Home home = new Home.HomeBuilder().withAddress("Vitebs").withWinCount(10).create();
        log.debug(home);
    }
}
