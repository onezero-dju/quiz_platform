<template>
  <div>
    <h1>퀴즈 결과</h1>
    <p>맞힌 개수: {{ correct_answers }} / {{ total_questions }}</p>
    <p>총 점수: {{ score }}</p>

    <!-- 사용자 이름 입력 -->
    <div v-if="!saved">
      <label>이름 입력:</label>
      <input v-model="username" placeholder="이름을 입력하세요" required />
      <button @click="saveScore">점수 저장</button>
    </div>

    <p v-if="saved">점수가 저장되었습니다!</p>

    <router-link to="/quizzes">퀴즈 목록으로 돌아가기</router-link>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      quiz_id: null,
      correct_answers: 0,
      total_questions: 0,
      score: 0,
      username: "", // 사용자 이름 저장
      saved: false // 점수 저장 여부
    };
  },
  created() {
    this.quiz_id = this.$route.params.id;
    this.correct_answers = parseInt(this.$route.query.correct_answers, 10);
    this.total_questions = parseInt(this.$route.query.total_questions, 10);
    this.score = Math.round((this.correct_answers / this.total_questions) * 100); // 점수 계산 (반올림)
  },
  methods: {
    async saveScore() {
      if (!this.username.trim()) {
        alert("이름을 입력하세요!");
        return;
      }

      try {
        await axios.post("http://localhost:8080/scores", {
          quiz_id: Number(this.quiz_id),
          user_name: this.username, // 사용자 입력 값 반영
          score: this.score
        });
        this.saved = true;
      } catch (error) {
        console.error("점수 저장 중 오류 발생:", error);
      }
    }
  }
};
</script>