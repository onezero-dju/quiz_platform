import { createApp } from 'vue';
import App from './App.vue';
import router from './router';

// Vuetify 불러오기
import { createVuetify } from 'vuetify';
import 'vuetify/styles'; // Vuetify 스타일 적용


import * as components from 'vuetify/components';
import * as directives from 'vuetify/directives';


const vuetify = createVuetify({
    components,
    directives,
});

const app = createApp(App);
app.use(router);
app.use(vuetify);
app.mount('#app');