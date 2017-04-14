package br.com.jfelipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ElectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElectionApplication.class, args);
    }
}
