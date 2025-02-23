<template>
  <v-app>
    <!-- 네비게이션 바 -->
    <v-app-bar color="primary" dark>
      <v-app-bar-title>퀴즈 앱</v-app-bar-title>
      <v-spacer></v-spacer>
      <v-btn to="/" text>홈</v-btn>
      <v-btn to="/quizzes" text>퀴즈 목록</v-btn>
      <v-btn to="/quiz/create" text>퀴즈 만들기</v-btn>
    </v-app-bar>

    <!-- 메인 컨텐츠 -->
    <v-main>
      <v-container>
        <router-view />
      </v-container>
    </v-main>

    <!-- 푸터 -->
    <v-footer color="grey darken-3" app>
      <v-container class="text-center white--text">
        &copy; 2025 퀴즈 앱 | 개발자: Bless
      </v-container>
    </v-footer>
  </v-app>
</template>

<style>
/* 전체적인 스타일 조정 */
.v-app-bar {
  font-weight: bold;
}

.v-main {
  background-color: #f5f5f5;
  min-height: calc(100vh - 64px); /* 화면 높이 조정 */
}

.v-footer {
  text-align: center;
  padding: 10px;
}
</style>