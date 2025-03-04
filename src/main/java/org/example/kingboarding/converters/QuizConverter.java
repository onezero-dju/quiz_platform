package org.example.kingboarding.converters;

import jakarta.persistence.Converter;
import org.example.kingboarding.dto.QuizDTO;
import org.example.kingboarding.entities.QuizEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class QuizConverter {
    public QuizDTO toDto(QuizEntity quizEntity) {
        return QuizDTO.builder()
                .id(quizEntity.getId())
                .title(quizEntity.getTitle())
                .category(quizEntity.getCategory())
                .build();
    }
}
