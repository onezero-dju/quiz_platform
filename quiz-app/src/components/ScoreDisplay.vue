<template>
  <div class="score-display">
    <h2>총 점수: {{ score }}</h2>
  </div>
</template>

<script>
export default {
  props: {
    score: Number,
  },
};
</script>

<style scoped>
.score-display {
  text-align: center;
  font-size: 24px;
  font-weight: bold;
  margin-top: 20px;
}
</style>