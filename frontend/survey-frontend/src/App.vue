<template>
  <div id="app">
    <NavBar />
    <div class="container mt-4">
      <router-view />
    </div>
    <footer class="mt-5 py-3 bg-dark text-white text-center">
      <div class="container">
        <p class="mb-0">GMU SWE 642 - Survey Application</p>
        <p class="small">Department of Computer Science</p>
      </div>
    </footer>
  </div>
</template>

<script>
import NavBar from './components/NavBar.vue'

export default {
  name: 'App',
  components: {
    NavBar
  }
}
</script>

<style>
:root {
  --gmu-green: #006633;
  --gmu-yellow: #FFCC33;
}

body {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.btn-primary {
  background-color: var(--gmu-green);
  border-color: var(--gmu-green);
}

.btn-primary:hover {
  background-color: #004d26;
  border-color: #004d26;
}

.btn-outline-primary {
  color: var(--gmu-green);
  border-color: var(--gmu-green);
}

.btn-outline-primary:hover {
  background-color: var(--gmu-green);
  border-color: var(--gmu-green);
}

.gmu-header {
  color: var(--gmu-green);
  border-bottom: 3px solid var(--gmu-yellow);
  padding-bottom: 0.5rem;
  margin-bottom: 1.5rem;
}

.form-control:focus, .form-select:focus {
  border-color: var(--gmu-yellow);
  box-shadow: 0 0 0 0.25rem rgba(255, 204, 51, 0.25);
}
</style>