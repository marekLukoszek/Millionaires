package game.scoreRecord;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScoreRepository extends CrudRepository<Score, Long> {
//    List<Score> findAllByUserId ();
    Score save(Score score);
}
