<template>
  <div class="question-card">
    <p>{{ question.question }}</p>
    <input v-model="userAnswer" placeholder="정답 입력" />
    <button @click="submitAnswer">제출</button>
  </div>
</template>

<script>
export default {
  props: {
    question: Object,
  },
  data() {
    return {
      userAnswer: '',
    };
  },
  methods: {
    submitAnswer() {
      this.$emit('answer-submitted', this.userAnswer);
    },
  },
};
</script>

<style scoped>
.question-card {
  border: 1px solid #ccc;
  padding: 15px;
  margin: 10px 0;
  border-radius: 5px;
}
</style>