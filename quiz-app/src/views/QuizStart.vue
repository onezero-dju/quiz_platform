<template>
  <div>
    <h1>퀴즈 시작</h1>
    <div v-if="current_question">
      <p>{{ current_question.question }}</p>
      <input v-model="user_answer" placeholder="정답 입력" />
      <button @click="checkAnswer">제출</button>
    </div>
    <p v-if="result" :class="{ correct: is_correct, incorrect: !is_correct }">
      {{ result }}
    </p>
  </div>
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
      correct_answers: 0 // 맞힌 문제 개수 저장
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
        this.correct_answers++; // 정답 개수 증가
      } else {
        this.result = `틀렸습니다! 정답: ${this.current_question.correct_answer}`;
        this.is_correct = false;
      }

      this.user_answer = '';
      this.current_index++;

      // 모든 문제를 풀면 결과 페이지로 이동
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

<style scoped>
.correct {
  color: green;
}

.incorrect {
  color: red;
}
</style>