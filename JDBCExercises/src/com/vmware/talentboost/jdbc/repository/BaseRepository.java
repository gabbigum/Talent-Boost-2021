package com.vmware.talentboost.jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseRepository {

    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;

    protected BaseRepository() {
        dbUrl = System.getenv("DB_URL");
        dbUser = System.getenv("DB_USER");
        dbPassword = System.getenv("DB_PASSWORD");
    }

    /**
     * Returns new {@link Connection} instance.
     */
    protected Connection getConnection() throws SQLException {
        // TODO: implement (1)
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

}
