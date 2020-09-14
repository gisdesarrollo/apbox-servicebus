package com.gisconsultoria.com.apiBox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Luis Enrique Morales Soriano
 */
@SpringBootApplication
@EnableScheduling
public class ApBox {

    public static void main(String [] args){
        SpringApplication.run(ApBox.class, args);
    }
}
