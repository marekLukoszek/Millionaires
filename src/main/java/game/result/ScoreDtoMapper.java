package game.result;

import game.authentication.User;
import game.authentication.UserDto;

import java.time.LocalDateTime;

public class ScoreDtoMapper {
    static ScoreDto map(Score score) {
        Long id = score.getId();
        LocalDateTime date = score.getDate();
        int result = score.getResult();
        Long usersId = score.getUsersId();
        return new ScoreDto(id, date, result, usersId);
    }
}
