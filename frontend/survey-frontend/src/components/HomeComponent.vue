<template>
  <div class="home">
    <div class="text-center mb-5">
      <div class="header-box p-4 mb-4">
        <h1><i class="fas fa-university me-2"></i>GMU Computer Science Department</h1>
        <p class="lead text-white mt-2">SWE 642 - Software Engineering for the World Wide Web</p>
      </div>
    </div>
    
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card shadow-sm">
          <div class="card-body">
            <h2 class="card-title gmu-header">Welcome to Campus Visit Survey</h2>
            <p class="lead">Thank you for your interest in George Mason University!</p>
            <p>
              This application allows prospective students to fill out a survey form to provide feedback about their campus visit.
              It also allows users to view all surveys recorded to date and update or delete individual surveys.
            </p>
            
            <div class="mt-4">
              <h4>Get Started</h4>
              <div class="row mt-3">
                <div class="col-md-6 mb-3">
                  <div class="card h-100">
                    <div class="card-body text-center">
                      <i class="fas fa-clipboard-list fa-3x mb-3" style="color: var(--gmu-green);"></i>
                      <h5 class="card-title">Fill Out Survey</h5>
                      <p class="card-text">Share your feedback about your campus visit experience.</p>
                      <router-link to="/survey" class="btn btn-primary">Take Survey</router-link>
                    </div>
                  </div>
                </div>
                <div class="col-md-6 mb-3">
                  <div class="card h-100">
                    <div class="card-body text-center">
                      <i class="fas fa-list-ul fa-3x mb-3" style="color: var(--gmu-green);"></i>
                      <h5 class="card-title">View All Surveys</h5>
                      <p class="card-text">Browse all submitted surveys and make changes if needed.</p>
                      <router-link to="/surveys" class="btn btn-primary">View Surveys</router-link>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomeComponent'
}
</script>

<style scoped>
.header-box {
  border: 5px solid var(--gmu-yellow);
  box-shadow: 0 10px 20px rgba(0,102,51,0.2);
  background-color: var(--gmu-green);
  text-align: center;
  border-radius: 8px;
  transition: all 0.3s ease;
}

.header-box h1 {
  color: white;
  margin: 0;
  font-weight: bold;
}

.card {
  border-radius: 8px;
  transition: transform 0.3s ease;
}

.card:hover {
  transform: translateY(-5px);
}
</style>