package org.example.kingboarding.services;

import lombok.RequiredArgsConstructor;
import org.example.kingboarding.converters.QuizConverter;
import org.example.kingboarding.dto.QuestionDTO;
import org.example.kingboarding.dto.QuizDTO;
import org.example.kingboarding.entities.QuizEntity;
import org.example.kingboarding.models.QuizRequest;
import org.example.kingboarding.repositories.QuestionRepository;
import org.example.kingboarding.repositories.QuizRepository;
import org.example.kingboarding.repositories.UserScoreRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuizConverter quizConverter;
    private final QuestionRepository questionRepository;
    private final UserScoreRepository userScoreRepository;
    public QuizDTO create(
            QuizRequest quizRequest
    ){


        var entity = QuizEntity.builder()
                .title(quizRequest.getTitle())
                .category(quizRequest.getCategory())
                .build();
        var saveQuiz = quizRepository.save(entity);
        return quizConverter.toDto(saveQuiz);
    }

    public List<QuizDTO> getAllQuizzes(){
        var quizzes = quizRepository.findAll();
        return quizzes.stream().map(quizConverter::toDto).toList();
    }

}
