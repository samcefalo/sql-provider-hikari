package io.github.eikefs.sql.provider.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlLiteConnection implements Connection {

    private String path;

    public SqlLiteConnection(String path) {
        this.path = path;
    }

    @Override
    public String driverClass() {
        return "org.sqlite.JDBC";
    }

    @Override
    public String url() {
        return "jdbc:sqlite:" + path;
    }

    @Override
    public java.sql.Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName(driverClass());
        return DriverManager.getConnection(url());
    }

}
