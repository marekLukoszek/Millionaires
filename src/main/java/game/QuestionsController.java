package game;

import game.authentication.UsersService;

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
    private UsersService usersService;

    public QuestionsController(QuestionsService questionsService, QuestionDto questionDto, UsersService usersService) {
        this.questionsService = questionsService;
        this.questionDto = questionDto;
        this.usersService = usersService;
    }

    @RequestMapping("/drawQuestion")
    String getQuestion(@RequestParam String start, HttpSession session, Model model) {
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
            model.addAttribute("prize", yourPrize - 1);
//            saveGameResult(yourPrize);
            session.setAttribute("difficulty", 0);
            return "end";
        }
    }

    @RequestMapping("/getStats")
    @ResponseBody
    LocalDate home() {
        return LocalDate.now();
    }

// Początek pracy nad zapisem wyników
//    String saveGameResult(int difficulty) {
//        String name = getLoggedUserName();
//        Optional<UserDto> userDto = usersService.findUserByUsername(name);
//        userDto.ifPresentOrElse((Consumer<? super UserDto>) userDto1 -> scoreService.saveScore(LocalDateTime.now(), difficulty, userDto1.getId()),
//                (Runnable) new UsernameNotFoundException(String.format("Użytkownik %s nie znaleziony", name)));
//    return "Zapisano wynik użytkownika %s " + name;
//    }
//
//    String getLoggedUserName() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        return auth.getName();
//    }
}
