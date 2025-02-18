<template>
  <div>
    <h1>퀴즈 만들기</h1>
    <form @submit.prevent="createQuiz">
      <label>퀴즈 제목:</label>
      <input v-model="title" placeholder="퀴즈 제목 입력" required />

      <label>퀴즈 설명:</label>
      <textarea v-model="description" placeholder="퀴즈 설명 입력"></textarea>

      <label>카테고리:</label>
      <input v-model="category" placeholder="카테고리 입력" required />

      <button type="submit">퀴즈 추가</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      title: '',
      description: '',
      category: ''
    };
  },
  methods: {
    async createQuiz() {
      try {
        const response = await axios.post('http://localhost:8080/quiz/create', {
          title: this.title,
          description: this.description,
          category: this.category
        });

        const quiz_id = response.data.id; // 생성된 퀴즈 ID 가져오기 (변수명 변경)
        this.$router.push(`/quiz/${quiz_id}/questions`); // 문제 추가 페이지로 이동
      } catch (error) {
        console.error("퀴즈 생성 중 오류 발생:", error);
      }
    },
  },
};
</script>