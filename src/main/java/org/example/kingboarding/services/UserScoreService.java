package org.example.kingboarding.services;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.kingboarding.converters.UserScoreConverter;
import org.example.kingboarding.dto.UserScoreDTO;
import org.example.kingboarding.entities.UserScoresEntity;
import org.example.kingboarding.models.UserScoreRequest;
import org.example.kingboarding.repositories.QuizRepository;
import org.example.kingboarding.repositories.UserScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserScoreService {

    private final UserScoreRepository userScoreRepository;
    private final QuizRepository quizRepository;
    private final UserScoreConverter userScoreConverter;

    public UserScoreDTO save(UserScoreRequest userScoreRequest) {

        var quizEntity = quizRepository.findById(userScoreRequest.getQuizId()).orElseThrow(
                ()-> new IllegalArgumentException("Quiz not found")
        );

        var entity = UserScoresEntity.builder()
                .quiz(quizEntity)
                .userName(userScoreRequest.getUserName())
                .score(userScoreRequest.getScore())
                .build();
        var savedEntity = userScoreRepository.save(entity);

        return userScoreConverter.toDTO(savedEntity);
    }

    public List<UserScoreDTO> getAllScores(long id) {

        List<UserScoresEntity> userScoreEntityList = userScoreRepository.findAllByQuizId(id);

        return userScoreEntityList.stream()
                .map(userScoreConverter::toDTO)
                .toList();



    }
    public List<UserScoreDTO> findByQuizIdOrderByScoreDesc(Long quizId) {

        List<UserScoresEntity> userScoresEntityList = userScoreRepository.findAllByQuizIdOrderByScoreDesc(quizId);

        return userScoresEntityList.stream().map(userScoreConverter::toDTO).toList();
    }
}
