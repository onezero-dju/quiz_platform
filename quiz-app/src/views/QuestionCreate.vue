<template>
  <div>
    <h1>퀴즈 문제 만들기</h1>

    <label>문제 개수:</label>
    <input v-model.number="question_count" type="number" min="1" @change="generateQuestionFields" />

    <div v-for="(question, index) in questions" :key="index">
      <label>문제 {{ index + 1 }}:</label>
      <input v-model="question.text" placeholder="문제 입력" required />

      <label>정답:</label>
      <input v-model="question.answer" placeholder="정답 입력" required />
    </div>

    <button @click="submitQuestions">문제 저장</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      quiz_id: null, // 현재 퀴즈 ID 저장 (변수명 변경)
      question_count: 1, // 사용자가 입력한 문제 개수 (변수명 변경)
      questions: []
    };
  },
  created() {
    this.quiz_id = this.$route.params.id; // URL에서 퀴즈 ID 가져오기
  },
  methods: {
    generateQuestionFields() {
      this.questions = Array.from({length: this.question_count}, () => ({
        text: '',
        answer: ''
      }));
    },
    async submitQuestions() {
      try {
        for (let q of this.questions) {
          await axios.post('http://localhost:8080/quiz', {
            quiz_id: this.quiz_id, // 스네이크 케이스 적용
            question: q.text,
            correct_answer: q.answer // 스네이크 케이스 적용
          });
        }
        alert("문제가 저장되었습니다!");
        this.$router.push('/quizzes'); // 문제 저장 후 퀴즈 목록으로 이동
      } catch (error) {
        console.error("문제 저장 중 오류 발생:", error);
      }
    }
  }
};
</script>