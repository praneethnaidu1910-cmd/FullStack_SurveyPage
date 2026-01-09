import { createRouter, createWebHistory } from 'vue-router'
import HomeComponent from '../components/HomeComponent.vue'
import SurveyForm from '../components/SurveyForm.vue'
import SurveyList from '../components/SurveyList.vue'
import SurveyEdit from '../components/SurveyEdit.vue'

// Define routes
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeComponent
  },
  {
    path: '/survey',
    name: 'survey',
    component: SurveyForm
  },
  {
    path: '/surveys',
    name: 'surveys',
    component: SurveyList
  },
  {
    path: '/surveys/:id/edit',
    name: 'survey-edit',
    component: SurveyEdit,
    props: true
  }
]

// Create router instance
const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router