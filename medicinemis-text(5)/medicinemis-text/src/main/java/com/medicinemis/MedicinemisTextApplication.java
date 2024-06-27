package com.medicinemis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class MedicinemisTextApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicinemisTextApplication.class, args);
    }

}
