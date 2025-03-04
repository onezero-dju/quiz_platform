package org.example.kingboarding.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.kingboarding.dto.UserScoreDTO;
import org.example.kingboarding.models.UserScoreRequest;
import org.example.kingboarding.services.UserScoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
@RequiredArgsConstructor
public class UserScoreController {

    private final UserScoreService userScoreService;

    @GetMapping("/quiz/{quizId}")
    public List<UserScoreDTO> getUserScores(
            @Valid
            @PathVariable
            long quizId
    ) {
        return userScoreService.getAllScores(quizId);

    }
    @PostMapping("")
    public UserScoreDTO saveUserScores(
            @Valid
            @RequestBody
            UserScoreRequest userScoreRequest
    ) {
        return userScoreService.save(userScoreRequest);
    }
    @GetMapping("/quiz/{quizId}/ranking")
    public List<UserScoreDTO> findAllByQuizIdOrderByScoreDesc(
            @PathVariable
            long quizId
    ){
        return userScoreService.findByQuizIdOrderByScoreDesc(quizId);
    }
}
