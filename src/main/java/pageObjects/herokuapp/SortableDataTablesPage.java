package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortableDataTablesPage extends BasePage {

    private By table = By.id("table1");

    private By headers = By.xpath("//table[@id='table1']//th");

    private By getTableRow(String index) {
        return By.xpath("//table[@id='table1']//tbody//tr[" + index + "]");
    }

    public SortableDataTablesPage clickTableColumn(String columnName) {
        driver.findElement(headers).findElement(By.xpath("//span[text() = '" + columnName + "']")).click();
        return this;
    }

    public SortableDataTablesPage checkTableIsDisplayed() {
        Assert.assertTrue(driver.findElement(table).isDisplayed());
        return this;
    }

    public List<List<String>> getTableRowsData() {
        Integer rowCount = driver.findElements(getTableRow("..")).size();
        List<List<String>> data = new ArrayList<>();
        for (int row = 0; row < rowCount; row++) {
            List<String> columnData = new ArrayList<>();
            Integer columnCount = driver.findElement(getTableRow(Integer.toString(row + 1))).findElements(By.xpath(".//td")).size();
            for (int column = 0; column < columnCount; column++) {
                columnData.add(driver.findElement(getTableRow(Integer.toString(row + 1))).findElement(By.xpath(".//td[" + (column + 1) + "]")).getText());
            }
            data.add(columnData);
        }
        return data;
    }

    public Map<String, List<String>> getTableData() {
        Map<String, List<String>> mapData = new HashMap<>();
        Integer headersCount = driver.findElements(headers).size();
        List<List<String>> tableData = getTableRowsData();
        for (int header = 0; header < headersCount; header++) {
            List<String> columnData = new ArrayList<>();
            for (List<String> data : tableData) {
                columnData.add(data.get(header));
            }
            mapData.put(driver.findElements(headers).get(header).getText(), columnData);
        }
        return mapData;
    }
}
