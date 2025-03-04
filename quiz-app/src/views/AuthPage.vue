<template>
  <div class="wrapper">
    <div class="container" :class="{ 'right-panel-active': isSignUpActive }">
      <!-- 회원가입 -->
      <div class="sign-up-container">
        <form @submit.prevent="handleSignUp">
          <h1>회원가입</h1>
          <div class="social-links">
            <div><a href="#"><i class="fa fa-facebook"></i></a></div>
            <div><a href="#"><i class="fa fa-twitter"></i></a></div>
            <div><a href="#"><i class="fa fa-linkedin"></i></a></div>
          </div>
          <span>또는 이메일을 사용하여 가입하세요</span>
          <input type="text" v-model="signUpData.name" placeholder="이름">
          <input type="email" v-model="signUpData.email" placeholder="이메일">
          <input type="password" v-model="signUpData.password" placeholder="비밀번호">
          <button class="form_btn" type="submit">가입하기</button>
        </form>
      </div>

      <!-- 로그인 -->
      <div class="sign-in-container">
        <form @submit.prevent="handleSignIn">
          <h1>로그인</h1>
          <div class="social-links">
            <div><a href="#"><i class="fa fa-facebook"></i></a></div>
            <div><a href="#"><i class="fa fa-twitter"></i></a></div>
            <div><a href="#"><i class="fa fa-linkedin"></i></a></div>
          </div>
          <span>또는 계정 정보를 입력하세요</span>
          <input type="email" v-model="signInData.email" placeholder="이메일">
          <input type="password" v-model="signInData.password" placeholder="비밀번호">
          <button class="form_btn" type="submit">로그인</button>
        </form>
      </div>

      <!-- 오버레이 -->
      <div class="overlay-container">
        <div class="overlay-left">
          <h1>다시 오신 것을 환영합니다!</h1>
          <p>계정이 있으신가요? 로그인해주세요.</p>
          <button class="overlay_btn" @click="togglePanel(false)">로그인</button>
        </div>
        <div class="overlay-right">
          <h1>안녕하세요!</h1>
          <p>개인 정보를 입력하고 우리와 함께하세요.</p>
          <button class="overlay_btn" @click="togglePanel(true)">회원가입</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isSignUpActive: false,
      signUpData: {
        name: "",
        email: "",
        password: "",
      },
      signInData: {
        email: "",
        password: "",
      },
    };
  },
  methods: {
    handleSignUp() {
      alert(`회원가입 완료: ${this.signUpData.name}`);
      console.log("회원가입 데이터", this.signUpData);
    },
    handleSignIn() {
      alert(`로그인 완료: ${this.signInData.email}`);
      console.log("로그인 데이터", this.signInData);
    },
    togglePanel(isSignUp) {
      this.isSignUpActive = isSignUp;
    },
  },
};
</script>

<style scoped>
@import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css");

* {
  box-sizing: border-box;
}
body {
  font-family: "Montserrat", sans-serif;
  margin: 0;
  padding: 0;
}
.wrapper {
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #ebecf0;
  overflow: hidden;
}
.container {
  border-radius: 10px;
  box-shadow: -5px -5px 10px #fff, 5px 5px 10px #babebc;
  position: absolute;
  width: 768px;
  min-height: 480px;
  overflow: hidden;
}
form {
  background: #ebecf0;
  display: flex;
  flex-direction: column;
  padding: 0 50px;
  height: 100%;
  justify-content: center;
  align-items: center;
}
input {
  background: #eee;
  padding: 16px;
  margin: 8px 0;
  width: 85%;
  border: 0;
  outline: none;
  border-radius: 20px;
}
button {
  border-radius: 20px;
  font-size: 12px;
  font-weight: bold;
  padding: 15px 45px;
  margin: 14px;
  cursor: pointer;
  transition: transform 80ms ease-in;
}
.overlay_btn {
  background-color: #ff4b2b;
  color: #fff;
}
.container.right-panel-active .sign-in-container {
  transform: translateX(100%);
  opacity: 0;
}
.container.right-panel-active .sign-up-container {
  transform: translateX(100%);
  opacity: 1;
  z-index: 2;
}
.container.right-panel-active .overlay-right {
  transform: translateX(-100%);
  opacity: 0;
}
.container.right-panel-active .overlay-left {
  transform: translateX(-100%);
  opacity: 1;
  z-index: 2;
}
.social-links {
  margin: 20px 0;
}
</style>