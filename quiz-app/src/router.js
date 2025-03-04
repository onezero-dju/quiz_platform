import { createRouter, createWebHistory } from 'vue-router';
import Home from './views/Home.vue';
import QuizList from './views/QuizList.vue';
import QuizCreate from './views/QuizCreate.vue';
import QuestionCreate from './views/QuestionCreate.vue';
import QuizStart from './views/QuizStart.vue';
import QuizResult from './views/QuizResult.vue';
import QuizSigning from './views/AuthPage.vue';
import MainLayout from "./layout/MainLayout.vue";
import AuthLayout from "./layout/AuthLayout.vue";
import AuthPage from "./views/AuthPage.vue";
const routes = [
    {
        path: '/',
        component: MainLayout,
        children: [
            { path: '', component: Home },
            { path: '/quizzes', component: QuizList },
            { path: '/quiz/create', component: QuizCreate },
            { path: '/quiz/:id/questions', component: QuestionCreate },
            { path: '/quiz/:id/start', component: QuizStart },
            { path: '/quiz/:id/result', component: QuizResult }
        ]

    },
    {
        path: '/auth',
        component: AuthLayout,
        children: [
            { path: '',component: AuthPage }
        ]
    }



];

const router = createRouter({
history: createWebHistory(),
routes,
});

export default router;