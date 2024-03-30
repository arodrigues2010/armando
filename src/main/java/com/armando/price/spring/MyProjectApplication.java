package com.armando.price.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyProjectApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(MyProjectApplication.class, args);
        } catch (Exception e) {
            // Manejo básico de la excepción. Puedes personalizarlo según tus necesidades.
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
