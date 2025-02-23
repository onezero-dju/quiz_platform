<template>
  <v-container>
    <v-row justify="center">
      <v-col cols="12" md="8">
        <v-card v-if="current_question">
          <v-card-title>{{ current_question.question }}</v-card-title>
          <v-card-text>
            <v-text-field v-model="user_answer" label="정답 입력" solo></v-text-field>
            <v-btn @click="checkAnswer" color="primary">제출</v-btn>
          </v-card-text>
        </v-card>

        <v-alert v-if="result" :type="is_correct ? 'success' : 'error'" class="mt-3">
          {{ result }}
        </v-alert>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      quiz_id: null,
      questions: [],
      current_index: 0,
      user_answer: '',
      result: '',
      is_correct: false,
    };
  },
  computed: {
    current_question() {
      return this.questions[this.current_index] || null;
    },
  },
  async created() {
    this.quiz_id = this.$route.params.id;

    try {
      const response = await axios.get(`http://localhost:8080/quiz/${this.quiz_id}`);
      this.questions = response.data;
    } catch (error) {
      console.error("퀴즈 문제를 가져오는 중 오류 발생:", error);
    }
  },
  methods: {
    checkAnswer() {
      if (!this.current_question) return;

      const correct_answer = this.current_question.correct_answer.trim().toLowerCase();
      const user_answer = this.user_answer.trim().toLowerCase();

      if (user_answer === correct_answer) {
        this.result = "정답!";
        this.is_correct = true;
      } else {
        this.result = `틀렸습니다! 정답: ${this.current_question.correct_answer}`;
        this.is_correct = false;
      }

      this.user_answer = '';
      this.current_index++;

      if (this.current_index >= this.questions.length) {
        this.$router.push({
          path: `/quiz/${this.quiz_id}/result`,
          query: {
            correct_answers: this.correct_answers,
            total_questions: this.questions.length
          }
        });
      }
    },
  },
};
</script>