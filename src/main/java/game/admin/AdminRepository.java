package game.admin;

import game.Questions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminRepository extends CrudRepository<Questions, Long> {
   @Transactional
   Questions save(Questions question);

   void deleteById(Long id);

   List<Questions> findAll();

   List<Questions> findAllByDifficulty(int difficulty);

}
