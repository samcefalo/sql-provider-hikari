package io.github.eikefs.sql.provider.connection;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.SQLException;

public class HikariConnection implements Connection {

    private String host, database, user, password;

    public HikariConnection(String host, String database, String user, String password) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    @Override
    public String driverClass() {
        return "";
    }

    @Override
    public String url() {
        return "";
    }

    @Override
    public java.sql.Connection connect() throws SQLException {
        HikariDataSource hikari = this.generateHikariDataSource();
        return hikari.getConnection();
    }

    private HikariDataSource generateHikariDataSource() {
        HikariDataSource hikari = new HikariDataSource();
        hikari.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        hikari.addDataSourceProperty("serverName", this.host);
        hikari.addDataSourceProperty("databaseName", this.database);
        hikari.addDataSourceProperty("user", this.user);
        hikari.addDataSourceProperty("password", this.password);
        hikari.addDataSourceProperty("useSSL", false);
        return hikari;
    }

}
