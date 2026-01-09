import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'

// Create Vue app instance
const app = createApp(App)

// Use router
app.use(router)

// Mount app to DOM
app.mount('#app')