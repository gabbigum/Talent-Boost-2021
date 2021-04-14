package com.vmware.talentboost.spring.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder =
                DataSourceBuilder.create();
        try {
            Properties properties = new Properties();
            ClassPathResource databasePropResource = new ClassPathResource("database.properties");
            properties.load(databasePropResource.getInputStream());

            dataSourceBuilder.username(properties.getProperty("db.user"));
            dataSourceBuilder.password(properties.getProperty("db.pass"));
            dataSourceBuilder.url(properties.getProperty("db.url"));
            String driver = properties.getProperty("db.driver");
            dataSourceBuilder.driverClassName(driver);
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataSourceBuilder.build();
    }
}
