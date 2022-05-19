package io.github.eikefs.sql.provider.connection;

import java.sql.SQLException;

public interface Connection {

    String driverClass();
    String url();
    java.sql.Connection connect() throws SQLException, ClassNotFoundException;

}
