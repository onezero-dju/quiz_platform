package org.example.kingboarding.repositories;

import org.example.kingboarding.entities.QuestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface QuestionRepository extends JpaRepository<QuestionsEntity, Long> {
    List<QuestionsEntity> findAllByQuizId(Long quizId);
}
