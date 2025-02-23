<template>
  <v-container fill-height>
    <v-row justify="center" align="center" class="h-100">
      <v-col cols="12" md="6">
        <v-card class="pa-5 text-center">
          <v-card-title class="text-h4 font-weight-bold">퀴즈 앱</v-card-title>
          <v-card-subtitle class="mb-4">재미있는 퀴즈를 풀어보세요!</v-card-subtitle>

          <v-btn to="/quizzes" color="primary" class="mb-3" block large>
            📋 퀴즈 목록 보기
          </v-btn>
          <v-btn to="/quiz/create" color="success" block large>
            ➕ 퀴즈 만들기
          </v-btn>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<style scoped>
.h-100 {
  height: 100vh;
}
</style>