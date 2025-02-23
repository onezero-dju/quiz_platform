<template>
  <v-container>
    <v-row justify="center">
      <v-col cols="12" md="8">
        <!-- 결과 카드 -->
        <v-card class="pa-5 text-center">
          <v-card-title class="text-h4 font-weight-bold">퀴즈 결과</v-card-title>
          <v-card-text>
            <p class="text-h6">맞힌 개수: {{ correct_answers }} / {{ total_questions }}</p>
            <p class="text-h3 font-weight-bold">총 점수: {{ score }}점</p>
          </v-card-text>
        </v-card>

        <!-- 이름 입력 및 점수 저장 -->
        <v-card class="pa-5 mt-5">
          <v-card-title class="text-h5">점수 저장</v-card-title>
          <v-card-text>
            <v-text-field v-model="username" label="이름 입력" outlined dense></v-text-field>
            <v-btn @click="saveScore" color="primary" block large>점수 저장</v-btn>
          </v-card-text>
        </v-card>

        <!-- 순위 목록 -->
        <v-card class="pa-5 mt-5" v-if="rankings.length > 0">
          <v-card-title class="text-h5">퀴즈 순위</v-card-title>
          <v-card-text>
            <v-table>
              <thead>
              <tr>
                <th>#</th>
                <th>이름</th>
                <th>점수</th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="(rank, index) in rankings" :key="rank.id">
                <td>{{ index + 1 }}</td>
                <td>{{ rank.user_name }}</td>
                <td>{{ rank.score }}점</td>
              </tr>
              </tbody>
            </v-table>
          </v-card-text>
        </v-card>

        <!-- 퀴즈 목록으로 돌아가기 -->
        <v-btn to="/quizzes" color="secondary" block class="mt-5">퀴즈 목록으로 돌아가기</v-btn>
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
      correct_answers: 0,
      total_questions: 0,
      score: 0,
      username: "",
      saved: false,
      rankings: [] // 순위 목록
    };
  },
  created() {
    this.quiz_id = this.$route.params.id;
    this.correct_answers = Number(this.$route.query.correct_answers) || 0;
    this.total_questions = Number(this.$route.query.total_questions) || 1;
    this.score = this.total_questions > 0
        ? Math.round((this.correct_answers / this.total_questions) * 100)
        : 0;

    this.fetchRankings();
  },
  methods: {
    async saveScore() {
      if (!this.username.trim()) {
        alert("이름을 입력하세요!");
        return;
      }

      try {
        await axios.post("http://localhost:8080/scores", {
          quiz_id: this.quiz_id,
          username: this.username,
          score: this.score
        });

        this.saved = true;
        this.fetchRankings();
      } catch (error) {
        console.error("점수 저장 중 오류 발생:", error);
      }
    },

    async fetchRankings() {
      try {
        const response = await axios.get(`http://localhost:8080/scores/quiz/${this.quiz_id}/ranking`);
        this.rankings = response.data;
      } catch (error) {
        console.error("순위를 불러오는 중 오류 발생:", error);
      }
    }
  }
};
</script>