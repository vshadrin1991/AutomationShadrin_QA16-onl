package sql;

import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectHelper extends DBConnector {
    private String select;
    private String from;

    public static SelectHelper getSelect() {
        return new SelectHelper();
    }

    public SelectHelper select(String select) {
        this.select = select;
        return this;
    }

    public SelectHelper from(String from) {
        this.from = from;
        return this;
    }

    @SneakyThrows
    public ResultSet execute() {
        return getStatement().executeQuery("SELECT " + select + " FROM " + from);
    }

    @SneakyThrows
    public List<Map<String, String>> getData() {
        ResultSet resultSet = execute();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        List<Map<String, String>> data = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, String> row = new HashMap<>();
            for (int index = 1; index <= resultSetMetaData.getColumnCount(); index++) {
                row.put(resultSetMetaData.getColumnName(index), resultSet.getString(index));
            }
            data.add(row);
        }
        return data;
    }
}
