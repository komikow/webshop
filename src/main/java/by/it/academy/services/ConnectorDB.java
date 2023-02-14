package by.it.academy.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static by.it.academy.entities.Constants.*;

public class ConnectorDB {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(SQL_DRIVER_NAME);
        return DriverManager.getConnection(SQL_URL, SQL_NAME, SQL_PASSWORD);
    }
}
