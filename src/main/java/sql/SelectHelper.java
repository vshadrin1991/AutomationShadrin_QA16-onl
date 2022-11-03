package sql;

import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectHelper {

    Statement statement;

    public SelectHelper(Statement statement) {
        this.statement = statement;
    }

    @SneakyThrows
    public List<Map<String, String>> select(String sql) {
        ResultSet resultSet = statement.executeQuery(sql);
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
