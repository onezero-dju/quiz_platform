package org.example.kingboarding.repositories;

import org.example.kingboarding.dto.QuizDTO;
import org.example.kingboarding.entities.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<QuizEntity,Long> {

}
