package com.example.dsns;

import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    @Autowired
    public DriverManagerDestination driverManagerDestination(DataSourceProperties dataSourceProperties) {
        return new DriverManagerDestination(
                dataSourceProperties.getUrl(),
                dataSourceProperties.getUsername(),
                dataSourceProperties.getPassword()
        );
    }
}
