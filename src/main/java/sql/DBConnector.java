package sql;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static propertyHelper.PropertyReader.getProperties;


public abstract class DBConnector {
    private static Connection connection;

    @SneakyThrows
    public Connection dbConnection() {
        if (connection == null) {
            connection = DriverManager.getConnection(getProperties().getProperty("url"));
        }
        return connection;
    }

    @SneakyThrows
    public Statement getStatement() {
        return dbConnection().createStatement();
    }
}
