package Lecture21;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;

import static sql.SelectHelper.getSelect;

public class Lecture21_1 extends BaseTest {


    @Test
    public void select_Test() {
        System.out.println(getSelect().select("*").from("user").getData());
    }
}
