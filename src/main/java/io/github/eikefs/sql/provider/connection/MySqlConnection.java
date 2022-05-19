package io.github.eikefs.sql.provider.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection implements Connection {

    private String host, database, user, password;

    public MySqlConnection(String host, String database, String user, String password) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    @Override
    public String driverClass() {
        return "com.mysql.cj.jdbc.Driver";
    }

    @Override
    public String url() {
        return "jdbc:mysql://" + host + "/" + database;
    }

    @Override
    public java.sql.Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName(driverClass());

        return DriverManager.getConnection(url(), user, password);
    }

}
