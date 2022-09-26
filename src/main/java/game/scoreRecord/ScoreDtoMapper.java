package game.scoreRecord;

import java.time.LocalDate;

public class ScoreDtoMapper {
    static ScoreDto map(Score score) {
        Long id = score.getId();
        LocalDate date = score.getDate();
        int result = score.getResult();
        Long userId = score.getUserId();
        return new ScoreDto(id, date, result, userId);
    }
}

