<template>
  <v-container>
    <v-row justify="center">
      <v-col cols="12" md="8">
        <v-card class="pa-5">
          <v-card-title class="text-h5 font-weight-bold">문제 만들기</v-card-title>
          <v-card-text>
            <v-form ref="form">
              <!-- 문제 개수 선택 -->
              <v-select
                  v-model="question_count"
                  :items="[1, 2, 3, 4, 5, 10]"
                  label="문제 개수 선택"
                  outlined
                  required
                  :rules="[rules.required]"
                  @change="generateQuestionFields"
              ></v-select>

              <!-- 문제 입력 필드 -->
              <div v-for="(question, index) in questions" :key="index">
                <v-text-field
                    v-model="question.text"
                    :label="`문제 ${index + 1}`"
                    outlined
                    required
                    :rules="[rules.required]"
                ></v-text-field>

                <v-text-field
                    v-model="question.answer"
                    label="정답 입력"
                    outlined
                    required
                    :rules="[rules.required]"
                ></v-text-field>
              </div>

              <v-btn color="primary" block large @click="validateAndSubmit">문제 저장</v-btn>
            </v-form>
          </v-card-text>
        </v-card>

        <!-- 퀴즈 목록으로 돌아가기 버튼 -->
        <v-btn to="/quizzes" color="secondary" block class="mt-3">퀴즈 목록으로 돌아가기</v-btn>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
import { watch } from "vue";

export default {
  data() {
    return {
      quiz_id: null,
      question_count: 1,
      questions: [], // 문제 목록

      // 🚀 유효성 검사 규칙
      rules: {
        required: (value) => !!value || "이 필드는 필수입니다!",
      },
    };
  },
  created() {
    this.quiz_id = this.$route.params.id || null;

    // 🚀 quiz_id가 null이면 목록으로 리디렉트
    if (!this.quiz_id) {
      console.error("퀴즈 ID가 존재하지 않습니다!");
      alert("잘못된 접근입니다. 퀴즈 목록으로 이동합니다.");
      this.$router.push("/quizzes");
    } else {
      this.generateQuestionFields();
    }
  },
  watch: {
    "$route.params.id"(newId) {
      if (newId) {
        this.quiz_id = newId;
        this.generateQuestionFields();
      }
    },
  },
  methods: {
    generateQuestionFields() {
      this.questions = Array.from({length: this.question_count}, () => ({
        text: "",
        answer: "",
      }));
    },

    async validateAndSubmit() {
      // 🚀 유효성 검사 실행
      if (this.$refs.form.validate()) {
        this.submitQuestions();
      }
    },

    async submitQuestions() {
      try {
        for (let q of this.questions) {
          await axios.post("http://localhost:8080/quiz", {
            quiz_id: this.quiz_id,
            question: q.text,
            correct_answer: q.answer,
          });
        }

        alert("문제가 저장되었습니다!");
        this.$router.push(`/quiz/${this.quiz_id}/start`);
      } catch (error) {
        console.error("문제 저장 중 오류 발생:", error);
      }
    },
  },
};
</script>