<template>
  <div>
    <h1>퀴즈 목록</h1>
    <ul>
      <li v-for="quiz in quizzes" :key="quiz.id">
        <router-link :to="`/quiz/${quiz.id}/start`">{{ quiz.title }}</router-link>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return { quizzes: [] };
  },
  async created() {
    const response = await axios.get('http://localhost:8080/quiz');
    this.quizzes = response.data;
  },
};
</script>