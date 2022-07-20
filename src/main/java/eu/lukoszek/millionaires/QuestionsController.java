package eu.lukoszek.millionaires;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
class QuestionsController{
    @RequestMapping("/drawQuestion")
    @ResponseBody
    String getParameter(@RequestParam String one, Model model){
        model.addAttribute("name", one);
        return "question";

    }

    @RequestMapping("/getStats")
    @ResponseBody
    LocalDate home() {
        return LocalDate.now();
    }
}
