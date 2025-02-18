import { createApp } from 'vue';
import App from './App.vue';
import router from './router'; // router.js 파일을 import

const app = createApp(App);

app.use(router); // Vue Router 사용
app.mount('#app'); // id가 "app"인 요소에 마운트
