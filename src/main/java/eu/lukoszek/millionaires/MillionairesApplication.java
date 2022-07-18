package eu.lukoszek.millionaires;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class MillionairesApplication{

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MillionairesApplication.class, args);
        QuestionsRepository questionsRepository = context.getBean(QuestionsRepository.class);
        Optional<Questions> question = questionsRepository.findById(1L);
        System.out.println(question.toString());
    }
}
