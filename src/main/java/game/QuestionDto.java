package game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    Long questionId;
    String questionBody;
    String answerA;
    String answerB;
    String answerC;
    String answerD;
    String rightAnswer;
    int difficulty;
}
