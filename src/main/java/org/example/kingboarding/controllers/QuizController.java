package org.example.kingboarding.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.kingboarding.dto.QuizDTO;
import org.example.kingboarding.models.QuizRequest;
import org.example.kingboarding.services.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping("")
    public QuizDTO create(@Valid @RequestBody QuizRequest quizRequest) {
        return quizService.create(quizRequest);
    }

    @GetMapping("/all-quiz")
    public List<QuizDTO> getQuiz() {
        return quizService.getAllQuizzes();
    }
}
