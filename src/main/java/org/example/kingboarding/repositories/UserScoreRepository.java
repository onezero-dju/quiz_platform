package org.example.kingboarding.repositories;

import org.example.kingboarding.entities.UserScoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserScoreRepository extends JpaRepository<UserScoresEntity,Long> {

    List<UserScoresEntity> findAllByQuizId(Long quizId);
    List<UserScoresEntity> findAllByQuizIdOrderByScoreDesc(Long quizId);
}
