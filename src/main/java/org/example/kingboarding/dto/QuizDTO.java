package org.example.kingboarding.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class QuizDTO {

    private long id;

    private String title;

    private String category;

    private List<QuestionDTO> questionList = new ArrayList<>();
    private List<UserScoresDTO> userScoresList =new ArrayList<>();
}
