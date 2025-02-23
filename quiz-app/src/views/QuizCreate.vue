<template>
  <v-container>
    <v-row justify="center">
      <v-col cols="12" md="8">
        <v-card class="pa-5">
          <v-card-title class="text-h5 font-weight-bold">퀴즈 만들기</v-card-title>
          <v-card-text>
            <!-- 제목 입력 -->
            <v-text-field v-model="title" label="퀴즈 제목" outlined required  :rules="[rules.title_required]"></v-text-field>
            <!-- 카테고리 선택 -->
            <v-text-field v-model="category" label="카테고리" outlined required  :rules="[rules.category_required]"></v-text-field>
            <v-btn color="primary" block large @click="createQuiz">퀴즈 추가</v-btn>
          </v-card-text>
        </v-card>

        <!-- 퀴즈 목록으로 돌아가기 버튼 -->
        <v-btn to="/quizzes" color="secondary" block class="mt-3">퀴즈 목록으로 돌아가기</v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import axios from 'axios';

export default {
  data() {
    return {
      title: '',
      category: '',
      rules: {
        title_required: (value) => !!value || "제목을 적어야 합니다!",
        category_required: (value) => !!value || "카테코리를 적어야 합니다!"
      },
    };
  },
  methods: {
    async validateAndCreateQuiz() {
      // 🚀 유효성 검사 실행
      if (this.$refs.form.validate()) {
        this.createQuiz();
      }
    },
    async createQuiz() {
      try {
        const response = await axios.post('http://localhost:8080/quiz/create', {
          title: this.title,
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