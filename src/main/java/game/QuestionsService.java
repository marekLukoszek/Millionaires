package game;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

@Service
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class QuestionsService {
    private QuestionsRepository questionsRepository;
    private QuestionsDtoMapper questionsDtoMapper;

    public QuestionsService(QuestionsRepository questionsRepository, QuestionsDtoMapper questionsDtoMapper) {
        this.questionsRepository = questionsRepository;
        this.questionsDtoMapper = questionsDtoMapper;
    }

    QuestionDto drawQuestion(int difficulty) {
        List<Questions> questionsList = questionsRepository.findAllByDifficulty(difficulty);
        Collections.shuffle(questionsList);
        return questionsDtoMapper.map(questionsList.get(0));
    }

    Boolean evaluate(String userAnswer, String rightAnswer) {
        return userAnswer.equals(rightAnswer);
    }
}


