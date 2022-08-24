package Lecture4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lecture4_1 {

    /*
    На вход дается число.
    Если число кратно 3 - возвращается T,
    если кратно 5, то M, а если 15 то S.
    */

    @Test
    public void test1() {
        Assert.assertEquals(getData(3), "T", "Values is different.");
    }

    @Test
    public void test2() {
        Assert.assertEquals(getData(5), "M", "Values is different.");
    }

    @Test
    public void test3() {
        Assert.assertEquals(getData(15), "S", "Values is different.");
    }

    @Test
    public void test4() {
        Assert.assertTrue(getData(2).isEmpty(), "Values is different.");
    }

    private String getData(int value) {
        if (value % 3 == 0 && value % 15 != 0) {
            return "T";
        } else if (value % 5 == 0 && value % 15 != 0) {
            return "M";
        } else if (value % 15 == 0) {
            return "S";
        }
        return "";
    }
}
