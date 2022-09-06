package game.admin;

import game.Questions;
import game.QuestionsDtoMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@Service
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AdminService {
    private AdminRepository adminRepository;
    private QuestionsDtoMapper questionsDtoMapper;

    public AdminService(AdminRepository adminRepository, QuestionsDtoMapper questionsDtoMapper) {
        this.adminRepository = adminRepository;
        this.questionsDtoMapper = questionsDtoMapper;
    }
    Questions addQuestion(Questions question){
       adminRepository.save(question);
       return question;
    }

    List<Questions> getQuestionsList()  {
        return adminRepository.findAll();
    }

    void deleteQuestion(Long id){
        adminRepository.deleteById(id);
        }

    List<Questions> getQuestionsListByDifficulty(int difficulty) {
        return adminRepository.findAllByDifficulty(difficulty);
    }
}