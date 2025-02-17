package org.example.kingboarding.repositories;

import org.example.kingboarding.entities.QuestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository extends JpaRepository<QuestionsEntity, Long> {
}
