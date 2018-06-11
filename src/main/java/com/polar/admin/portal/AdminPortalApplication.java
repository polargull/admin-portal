package com.polar.admin.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class AdminPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminPortalApplication.class, args);
    }
}
