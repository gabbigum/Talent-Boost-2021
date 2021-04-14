package com.vmware.talentboost.spring.impl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.vmware.talentboost.spring.IRepository;
import com.vmware.talentboost.spring.data.UserAccount;

import javax.sql.DataSource;

@Component
public class JdbcRepository implements IRepository {

    private Connection connection;
    private JdbcTemplate jdbcTemplate;

    // Task 0: Setup your database.
    //			- Create a local database.
    //			- Populate it using the provided script.
    //			- Put your specific values to the database.properties files. done
    // Task 1: Take a short look at how currently data retrieval is done.
    // Task 2: Switch to using Spring's database support.
    //			- Create datasource
    //			- (optional) Use the database.properties for your strings.
    //			- Use Spring's JdbcTemplate instead of Connection.
    //			- Re-factor the methods to work with this JdbcTemplate.

    @Autowired
    public JdbcRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        try {
            Properties properties = new Properties();
            ClassPathResource databasePropResource = new ClassPathResource("database.properties");
            properties.load(databasePropResource.getInputStream());
            String user = properties.getProperty("db.user");
            String pass = properties.getProperty("db.pass");
            String driver = properties.getProperty("db.driver");
            String url = properties.getProperty("db.url");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCapitalOf(String country) {
        String sql = "select capital from capitals where country like ?";
        return jdbcTemplate.queryForObject(sql, String.class, country);
    }

    public List<String> getCountries() {
        String sql = "select country from capitals";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public List<UserAccount> getAccounts() {
        String sql = "select name, role from users, roles where users.role_id=roles.id";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {
                    String userName = rs.getString("name");

                }
        );
    }

}
