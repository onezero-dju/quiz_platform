package org.example.kingboarding.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@Entity(name = "quizzes")
public class QuizEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String title;
    private String category;

    @OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionsEntity> questions = new ArrayList<>();

    @OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserScoresEntity> userScores = new ArrayList<>();
}
