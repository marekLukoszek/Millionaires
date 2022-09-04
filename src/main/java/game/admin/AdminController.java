package game.admin;

import game.QuestionDto;
import game.Questions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    private AdminService adminService;
    private QuestionDto questionDto;

    public AdminController(AdminService adminService, QuestionDto questionDto) {
        this.adminService = adminService;
        this.questionDto = questionDto;
    }

    @RequestMapping("/addQuestion")
    String adminAddQuestion(@RequestParam String questionBody, String answerA, String answerB, String answerC, String answerD,
                            String rightAnswer, int difficulty, Model model) {
        Questions question = new Questions(questionBody, answerA, answerB, answerC, answerD, rightAnswer, difficulty);
        Questions addedQuestion = adminService.addQuestion(question);
        System.out.println(addedQuestion.getQuestionBody());
        model.addAttribute("addedQuestionBody", addedQuestion.getQuestionBody());
        model.addAttribute("addedQuestionId", addedQuestion.getQuestionId());
        return "adminTaskDone";
    }
    @RequestMapping("/getAllQuestions")
    String getQuestionsList (Model model){
    List<Questions> questionsList = adminService.getQuestionsList();
    model.addAttribute("list", questionsList);
        return "questionsList";
    }

}
