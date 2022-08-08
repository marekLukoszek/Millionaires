package eu.lukoszek.millionaires.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MillionairesApplication{

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MillionairesApplication.class, args);
    }
}
