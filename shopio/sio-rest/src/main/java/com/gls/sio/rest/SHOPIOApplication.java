package com.gls.sio.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gls.sio.rest.factory.contant.PackageConstants;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {
        PackageConstants.ALL_MODULE,
        PackageConstants.PERSISTENT_SERVICE
})
@EnableJpaRepositories(basePackages = {
        PackageConstants.PERSISTENT_REPOSITORY
})
@EntityScan(basePackages = {
        PackageConstants.PERSISTENT_ENTITY
})
@PropertySource("classpath:liquibase.properties")
@PropertySource("classpath:file.properties")
public class SHOPIOApplication
{
    public static void main(String[] args)
    {
       //Dang o nhanh test
    }
}
