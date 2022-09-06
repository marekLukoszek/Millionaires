package game.admin;

import game.QuestionDto;
import game.Questions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
        System.out.println("test 1");
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
    @RequestMapping("/getQuestionsByDifficulty")
    String getQuestionsListByDifficulty(@RequestParam int difficulty, Model model){
        int difficultyInt = (int)difficulty;
        List<Questions> questionsList = adminService.getQuestionsListByDifficulty(difficultyInt);
        model.addAttribute("list", questionsList);
        return "questionsList";
    }

    @RequestMapping("/delete")
    String deleteQuestionById(@RequestParam Long questionId, Model model){
        List<Questions> list = adminService.getQuestionsList();
        list.removeIf(questions -> !(questions.getQuestionId().equals(questionId)));
        adminService.deleteQuestion(questionId);
        model.addAttribute(list);
        return "questionsList";
    }
}
