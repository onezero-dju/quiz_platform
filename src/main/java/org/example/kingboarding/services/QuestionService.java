package org.example.kingboarding.services;

import lombok.RequiredArgsConstructor;
import org.example.kingboarding.converters.QuestionConverter;
import org.example.kingboarding.dto.QuestionDTO;
import org.example.kingboarding.entities.QuestionsEntity;
import org.example.kingboarding.models.QuestionRequest;
import org.example.kingboarding.repositories.QuestionRepository;
import org.example.kingboarding.repositories.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;
    private final QuestionConverter questionConverter;

    public QuestionDTO createQuestion(QuestionRequest questionRequest) {
        var quizEntity = quizRepository.findById(questionRequest.getQuizId()).get();

        var entity = QuestionsEntity.builder()
                .quiz(quizEntity)
                .question(questionRequest.getQuestion())
                .correctAnswer(questionRequest.getCorrectAnswer())
                .build();

        var savedEntity = questionRepository.save(entity);
        return questionConverter.toDTO(savedEntity);
    }

}
