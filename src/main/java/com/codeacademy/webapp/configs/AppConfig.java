package com.codeacademy.webapp.configs;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@PropertySource("classpath:application.properties")
public class AppConfig {
//    @Bean
//    public DataSource securityDataSource(){
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("spring.datasource.driver-class-name");
//        dataSourceBuilder.url("spring.datasource.url");
//        dataSourceBuilder.username("blog_admin");
//        dataSourceBuilder.password("admin");
//        return dataSourceBuilder.build();
//    }
}
