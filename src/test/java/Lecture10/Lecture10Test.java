package Lecture10;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.NavigationItems;
import pageObjects.herokuapp.NavigationPage;
import pageObjects.herokuapp.SortableDataTablesPage;
import pageObjects.saucedemo.LoginPage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lecture10Test extends BaseTest {
    LoginPage loginPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage();
    }

    @Test
    public void test() {
        new NavigationPage().open().navigateTo(NavigationItems.SORTABLE_DATA_TABLES);
        Map<String, List<String>> mapTableData = new SortableDataTablesPage().checkTableIsDisplayed().clickTableColumn("Last Name").getTableData();
        List<List<String>> tableData = new SortableDataTablesPage().getTableRowsData();
        Assert.assertTrue(tableData.get(2).contains("$100.00"));
        List<String> lastNameData = mapTableData.get("Last Name");
        Assert.assertEquals(lastNameData, lastNameData.stream().sorted().collect(Collectors.toList()));
    }
}
