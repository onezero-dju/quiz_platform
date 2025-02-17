package org.example.kingboarding.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Entity(name = "questions")
public class QuestionsEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private QuizEntity quiz;
    @Column(columnDefinition = "TEXT")
    private String question;
    private String correctAnswer;

}
