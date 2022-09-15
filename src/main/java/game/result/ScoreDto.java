package game.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class ScoreDto {
        private Long id;
        private LocalDateTime date;
        private int result;
        private Long usersId;
    }

