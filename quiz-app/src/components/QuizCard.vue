<template>
  <div class="quiz-card">
    <h3>{{ quiz.title }}</h3>
    <p>카테고리: {{ quiz.category }}</p>
    <router-link :to="`/quiz/${quiz.id}/start`">퀴즈 풀기</router-link>
  </div>
</template>

<script>
export default {
  props: {
    quiz: Object,
  },
};
</script>

<style scoped>
.quiz-card {
  border: 1px solid #ddd;
  padding: 15px;
  border-radius: 5px;
  margin: 10px 0;
}
</style>