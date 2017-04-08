package com.gl.ecom.rest;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.gl.ecom")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
