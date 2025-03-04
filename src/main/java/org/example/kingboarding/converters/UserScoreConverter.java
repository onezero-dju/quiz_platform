package org.example.kingboarding.converters;

import org.example.kingboarding.dto.UserScoreDTO;
import org.example.kingboarding.entities.UserScoresEntity;
import org.springframework.stereotype.Service;

@Service
public class UserScoreConverter {

    public UserScoreDTO toDTO(UserScoresEntity userScoresEntity) {
        return UserScoreDTO.builder().
                id(userScoresEntity.getId()).
                quizId(userScoresEntity.getQuiz().getId()).
                userName(userScoresEntity.getUserName()).
                score(userScoresEntity.getScore()).
                build();
    }
}
