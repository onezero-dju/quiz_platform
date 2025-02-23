<template>
  <v-container>
    <v-row>
      <v-col v-for="quiz in quizzes" :key="quiz.id" cols="12" md="4">
        <v-card>
          <v-card-title>{{ quiz.title }}</v-card-title>
          <v-card-subtitle>{{ quiz.category }}</v-card-subtitle>
          <v-card-text>{{ quiz.description }}</v-card-text>
          <v-card-actions>
            <v-btn :to="`/quiz/${quiz.id}/start`" color="primary">퀴즈 시작</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
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