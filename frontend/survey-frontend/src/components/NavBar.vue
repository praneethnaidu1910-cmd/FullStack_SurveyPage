<template>
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: var(--gmu-green);">
      <div class="container">
        <router-link class="navbar-brand" to="/">
          <i class="fas fa-university me-2"></i>GMU CS Department
        </router-link>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav ms-auto">
            <li class="nav-item">
              <router-link class="nav-link" :class="{ active: $route.path === '/' }" to="/">Home</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" :class="{ active: $route.path === '/survey' }" to="/survey">Student Survey</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" :class="{ active: $route.path === '/surveys' }" to="/surveys">List All Surveys</router-link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </template>
  
  <script>
  export default {
    name: 'NavBar'
  }
  </script>
  
  <style scoped>
  .navbar-brand, .nav-link {
    color: white !important;
    transition: all 0.3s ease;
  }
  
  .nav-link {
    position: relative;
    padding: 0.5rem 1rem;
    margin: 0 0.2rem;
  }
  
  .nav-link::after {
    content: '';
    position: absolute;
    width: 0;
    height: 2px;
    bottom: 0;
    left: 50%;
    background-color: var(--gmu-yellow);
    transition: all 0.3s ease;
  }
  
  .nav-link:hover::after, .nav-link.active::after {
    width: 100%;
    left: 0;
  }
  
  .nav-link:hover, .nav-link.active {
    color: var(--gmu-yellow) !important;
  }
  </style>