package eu.lukoszek.millionaires;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

import static java.lang.Integer.parseInt;


@Controller
class QuestionsController {
    QuestionsService questionsService;

    public QuestionsController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @RequestMapping("/drawQuestion")
    String getParameter(@RequestParam String start, Model model) {
        model.addAttribute("name", start);
        Questions question = questionsService.drawQuestion(parseInt(start));
        model.addAttribute("questionBody", question.getQuestionBody());
        model.addAttribute("answerA", question.getAnswerA());
        model.addAttribute("answerB", question.getAnswerB());
        model.addAttribute("answerC", question.getAnswerC());
        model.addAttribute("answerD", question.getAnswerD());
        return "question";
    }

    @RequestMapping("/response")
    String checkAnswer(@RequestParam String myAnswer, Model model){


    return null;
    }
    @RequestMapping("/getStats")
    @ResponseBody
    LocalDate home() {
        return LocalDate.now();
    }
}
