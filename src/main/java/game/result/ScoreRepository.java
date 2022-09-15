package game.result;

import game.authentication.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ScoreRepository extends CrudRepository<Score, String> {
    List<Score> findAll();
    List<Score> findAllByUserName(String userName);
    List<Score> findAllByResult(int result);
    List<Score> findAllByDate(LocalDateTime begin, LocalDateTime end);
    Score save(Score score);
}
