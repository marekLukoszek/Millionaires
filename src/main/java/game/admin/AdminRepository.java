package game.admin;

import game.Questions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public interface AdminRepository extends CrudRepository<Questions, Long> {
   @Transactional
   Questions save(Questions question);

   void deleteById(Long id);
}
