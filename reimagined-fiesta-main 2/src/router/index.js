import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import QuizInfo from '../views/QuizInfo.vue'
import StaticManual from '../views/StaticManual'
import StaticQuestionBank from '../views/StaticQuestionBank'
import Dynamic from '../views/Dynamic.vue'
import LeaderBoard from '../views/LeaderBoard.vue'
import MyQuiz from '../views/MyQuiz.vue'
import PastQuiz from '../views/PastQuiz.vue'
import UpcomingQuiz from '../views/UpcomingQuiz.vue'
import Register from '../views/Register.vue'
import HomePage from '../views/HomePage.vue'
import Preview from '../views/Preview.vue'
import Profile from '../views/Profile.vue'
import PreviewDynamic from '../views/PreviewDynamic.vue'
import Manual from '../views/Manual.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/Login',
    name: 'Login',
    component: Login
  },
  {
    path: '/QuizInfo',
    name: 'QuizInfo',
    component: QuizInfo
  },
  {
    path: '/StaticManual',
    name: 'StaticManual',
    component: StaticManual
  },
  {
    path: '/StaticQuestionBank',
    name: 'StaticQuestionBank',
    component: StaticQuestionBank
  },
  {
    path: '/Dynamic',
    name: 'Dynamic',
    component: Dynamic
  },
  {
    path: '/Preview',
    name: 'Preview',
    component: Preview
  },
  {
    path: '/MyQuiz',
    name: 'MyQuiz',
    component: MyQuiz
  },
  {
    path: '/LeaderBoard',
    name: 'LeaderBoard',
    component: LeaderBoard
  },
  {
    path: '/PastQuiz',
    name: 'PastQuiz',
    component: PastQuiz
  },
  {
    path: '/UpcomingQuiz',
    name: 'UpcomingQuiz',
    component: UpcomingQuiz
  },
  {
    path: '/Register',
    name: 'Register',
    component: Register
  },
  {
    path: '/HomePage',
    name: 'HomePage',
    component: HomePage
  },
  {
    path: '/Profile',
    name: 'Profile',
    component: Profile
  },
  {
    path: '/PreviewDynamic',
    name: 'PreviewDynamic',
    component: PreviewDynamic
  },
  {
    path: '/Manual',
    name: 'Manual',
    component: Manual
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
