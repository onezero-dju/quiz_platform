package org.example.kingboarding.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.kingboarding.dto.QuestionDTO;
import org.example.kingboarding.models.QuestionRequest;
import org.example.kingboarding.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/{id}")
    public List<QuestionDTO> getQuestion(
            @PathVariable
            long id
    ){
        return questionService.getAllQuestions(id);
    }
    @PostMapping("")
    public QuestionDTO postQuestion(
            @Valid
            @RequestBody
            QuestionRequest questionRequest
    ){
        return questionService.createQuestion(questionRequest);
    }
}
