package com.example.qualitycontrolsystem.model;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://qcdb.postgres.database.azure.com/qcsystem")
                .username("ARiA")
                .password("Seal@140208")
                .build();
    }
}
