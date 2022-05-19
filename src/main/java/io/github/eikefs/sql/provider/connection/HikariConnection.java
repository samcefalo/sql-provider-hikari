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
        return "com.mysql.jdbc.Driver";
    }

    @Override
    public String url() {
        return "jdbc:mysql://" + host + "/" + database;
    }

    @Override
    public java.sql.Connection connect() throws SQLException {
        HikariDataSource hikari = this.generateHikariDataSource();
        return hikari.getConnection();
    }

    private HikariDataSource generateHikariDataSource() {
        HikariDataSource hikari = new HikariDataSource();
        hikari.setJdbcUrl(url());
        hikari.addDataSourceProperty("user", this.user);
        hikari.addDataSourceProperty("password", this.password);
        //hikari.addDataSourceProperty("useSSL", false);
        hikari.addDataSourceProperty("cachePrepStmts", "true");
        hikari.addDataSourceProperty("prepStmtCacheSize", "250");
        hikari.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return hikari;
    }

}
