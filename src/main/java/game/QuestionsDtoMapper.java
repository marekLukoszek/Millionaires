package game;

import org.springframework.stereotype.Service;

@Service
class QuestionsDtoMapper {
    private final QuestionsRepository questionsRepository;

    QuestionsDtoMapper(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    QuestionDto map(Questions questions) {
        QuestionDto dto = new QuestionDto();
        dto.setQuestionId(questions.getQuestionId());
        dto.setQuestionBody(questions.getQuestionBody());
        dto.setAnswerA(questions.getAnswerA());
        dto.setAnswerB(questions.getAnswerB());
        dto.setAnswerC(questions.getAnswerC());
        dto.setAnswerD(questions.getAnswerD());
        dto.setRightAnswer(questions.getRightAnswer());
        dto.setDifficulty(questions.getDifficulty());

        return dto;
    }
}
