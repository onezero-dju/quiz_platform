<template>
  <div>
    <nav>
      <router-link to="/">홈</router-link>
      <router-link to="/quizzes">퀴즈 목록</router-link>
      <router-link to="/quiz/create">퀴즈 만들기</router-link>
    </nav>
    <router-view /> <!-- 여기에 라우터의 페이지가 표시됨 -->
  </div>
</template>

<style>
nav {
  display: flex;
  gap: 10px;
  margin-bottom: 20px;
}
</style>