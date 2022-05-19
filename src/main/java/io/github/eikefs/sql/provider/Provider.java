package io.github.eikefs.sql.provider;

import io.github.eikefs.sql.provider.connection.Connection;
import io.github.eikefs.sql.provider.connection.HikariConnection;
import io.github.eikefs.sql.provider.connection.MySqlConnection;
import io.github.eikefs.sql.provider.connection.SqlLiteConnection;
import io.github.eikefs.sql.provider.database.Database;

public class Provider {

    private Provider() {
    }

    private static final Provider instance = new Provider();

    public static Provider getInstance() {
        return instance;
    }

    private java.sql.Connection newConnection(Connection connection) {
        try {
            return connection.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Database submitSqlLite(String path) {
        SqlLiteConnection sqlLiteConnection = new SqlLiteConnection(path);
        return new Database(newConnection(sqlLiteConnection));
    }

    public Database submitMySql(String host, String database, String user, String pass) {
        MySqlConnection mySqlConnection = new MySqlConnection(host, database, user, pass);
        return new Database(newConnection(mySqlConnection));
    }

    public Database submitHikari(String host, String database, String user, String pass) {
        HikariConnection hikariConnection = new HikariConnection(host, database, user, pass);
        return new Database(newConnection(hikariConnection));
    }

}
