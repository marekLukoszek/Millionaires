package game.admin;

import game.QuestionDto;
import game.Questions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    private AdminService adminService;
    private QuestionDto questionDto;

    public AdminController(AdminService adminService, QuestionDto questionDto) {
        this.adminService = adminService;
        this.questionDto = questionDto;
    }

    @RequestMapping("/addQuestion")
    String adminTaskUse(@RequestParam String questionBody, String answerA,String answerB,String answerC,String answerD,
                        String rightAnswer, int difficulty, Model model) {
        Questions question = new Questions(questionBody, answerA, answerB, answerC, answerD, rightAnswer, difficulty);
        Questions addedQuestion = adminService.addQuestion(question);
        model.addAttribute(addedQuestion);
        return "adminTaskDone";
    }
}
