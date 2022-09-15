package game.result;

import game.authentication.User;
import game.authentication.UserDto;
import game.authentication.UsersDtoMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ScoreService {
    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public List<ScoreDto> findAllByUser(String userName) {
        List<Score> scoreList = scoreRepository.findAllByUserName(userName);
        return scoreList.stream()
                .map(ScoreDtoMapper::map)
                .collect(Collectors.toList());
    }
}
