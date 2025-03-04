package org.example.kingboarding.converters;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.example.kingboarding.dto.QuestionDTO;
import org.example.kingboarding.entities.QuestionsEntity;
import org.springframework.stereotype.Service;


@Service
public class QuestionConverter {

    public QuestionDTO toDTO(QuestionsEntity questionsEntity) {
        return QuestionDTO.builder()
                .id(questionsEntity.getId())
                .quizId(questionsEntity.getQuiz().getId())
                .question(questionsEntity.getQuestion())
                .correctAnswer(questionsEntity.getCorrectAnswer())
                .build();
    }
}
