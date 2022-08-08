package eu.lukoszek.millionaires.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;


@Controller
class QuestionsController {
    private QuestionsService questionsService;
    private QuestionDto questionDto;

    public QuestionsController(QuestionsService questionsService, QuestionDto questionDto) {
        this.questionsService = questionsService;
        this.questionDto = questionDto;
    }

    @RequestMapping("/drawQuestion")
    String getParameter(@RequestParam String start, HttpSession session, Model model) {
        if (session.getAttribute("difficulty") == null) {
            session.setAttribute("difficulty", 0);
            questionDto = questionsService.drawQuestion(1);
        } else {
            int diff = (int) session.getAttribute("difficulty");
            int temp = (parseInt(start) + diff + 1);
            questionDto = questionsService.drawQuestion(temp);
        }
        session.setAttribute("rightAnswer", questionDto.getRightAnswer());
        session.setAttribute("difficulty", questionDto.getDifficulty());
        session.setAttribute("questionId", questionDto.getQuestionId());
        model.addAttribute("questionBody", questionDto.getQuestionBody());
        model.addAttribute("answerA", questionDto.getAnswerA());
        model.addAttribute("answerB", questionDto.getAnswerB());
        model.addAttribute("answerC", questionDto.getAnswerC());
        model.addAttribute("answerD", questionDto.getAnswerD());


        return "question";
    }

    @RequestMapping("/response")
    String checkAnswer(@RequestParam String userAnswer, HttpSession session, Model model) {
        String goodAnswer = (String) session.getAttribute("rightAnswer");
        boolean result = questionsService.evaluate(userAnswer, goodAnswer);
        if (result) {
            model.addAttribute("result", "poprawna");
            return "evaluation";
        } else {
            model.addAttribute("result", "błedna");
            int yourPrize = (int) session.getAttribute("difficulty");
            model.addAttribute("prize",yourPrize-1);
            session.setAttribute("difficulty", 0);
            return "end";
        }
    }

    @RequestMapping("/getStats")
    @ResponseBody
    LocalDate home() {
        return LocalDate.now();
    }
}
