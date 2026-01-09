<template>
    <div class="survey-edit">
      <div class="header-box mb-4">
        <h1><i class="fas fa-edit me-2"></i>Edit Survey</h1>
      </div>
      
      <div class="card shadow-sm">
        <div class="card-body">
          <div v-if="loading" class="text-center my-5">
            <div class="spinner-border text-primary" role="status">
              <span class="visually-hidden">Loading...</span>
            </div>
            <p class="mt-2">Loading survey data...</p>
          </div>
          
          <div v-else-if="error" class="alert alert-danger" role="alert">
            <i class="fas fa-exclamation-triangle me-2"></i>{{ error }}
            <div class="mt-3">
              <router-link to="/surveys" class="btn btn-primary">Back to Surveys</router-link>
            </div>
          </div>
          
          <form v-else @submit.prevent="submitForm">
            <!-- Personal Information -->
            <h3 class="section-title"><i class="fas fa-user me-2"></i>Personal Information</h3>
            <div class="row mb-3">
              <div class="col-md-6">
                <label for="firstName" class="form-label">First Name <span class="text-danger">*</span></label>
                <input 
                  type="text" 
                  class="form-control" 
                  id="firstName" 
                  v-model="survey.firstName" 
                  required
                  :class="{ 'is-invalid': errors.firstName }"
                >
                <div v-if="errors.firstName" class="invalid-feedback">{{ errors.firstName }}</div>
              </div>
              <div class="col-md-6">
                <label for="lastName" class="form-label">Last Name <span class="text-danger">*</span></label>
                <input 
                  type="text" 
                  class="form-control" 
                  id="lastName" 
                  v-model="survey.lastName" 
                  required
                  :class="{ 'is-invalid': errors.lastName }"
                >
                <div v-if="errors.lastName" class="invalid-feedback">{{ errors.lastName }}</div>
              </div>
            </div>
  
            <!-- Address Information -->
            <div class="mb-3">
              <label for="address" class="form-label">Street Address <span class="text-danger">*</span></label>
              <input 
                type="text" 
                class="form-control" 
                id="address" 
                v-model="survey.address" 
                required
                :class="{ 'is-invalid': errors.address }"
              >
              <div v-if="errors.address" class="invalid-feedback">{{ errors.address }}</div>
            </div>
  
            <div class="row mb-3">
              <div class="col-md-4">
                <label for="city" class="form-label">City <span class="text-danger">*</span></label>
                <input 
                  type="text" 
                  class="form-control" 
                  id="city" 
                  v-model="survey.city" 
                  required
                  :class="{ 'is-invalid': errors.city }"
                >
                <div v-if="errors.city" class="invalid-feedback">{{ errors.city }}</div>
              </div>
              <div class="col-md-4">
                <label for="state" class="form-label">State <span class="text-danger">*</span></label>
                <input 
                  type="text" 
                  class="form-control" 
                  id="state" 
                  v-model="survey.state" 
                  required
                  :class="{ 'is-invalid': errors.state }"
                >
                <div v-if="errors.state" class="invalid-feedback">{{ errors.state }}</div>
              </div>
              <div class="col-md-4">
                <label for="zip" class="form-label">ZIP Code <span class="text-danger">*</span></label>
                <input 
                  type="text" 
                  class="form-control" 
                  id="zip" 
                  v-model="survey.zip" 
                  pattern="[0-9]{5}" 
                  maxlength="5" 
                  required
                  :class="{ 'is-invalid': errors.zip }"
                >
                <div v-if="errors.zip" class="invalid-feedback">{{ errors.zip }}</div>
              </div>
            </div>
  
            <div class="row mb-3">
              <div class="col-md-6">
                <label for="phoneNumber" class="form-label">Phone Number <span class="text-danger">*</span></label>
                <input 
                  type="tel" 
                  class="form-control" 
                  id="phoneNumber" 
                  v-model="survey.phoneNumber" 
                  placeholder="XXX-XXX-XXXX" 
                  pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" 
                  required
                  :class="{ 'is-invalid': errors.phoneNumber }"
                >
                <div v-if="errors.phoneNumber" class="invalid-feedback">{{ errors.phoneNumber }}</div>
                <small class="form-text text-muted">Format: XXX-XXX-XXXX</small>
              </div>
              <div class="col-md-6">
                <label for="email" class="form-label">Email <span class="text-danger">*</span></label>
                <input 
                  type="email" 
                  class="form-control" 
                  id="email" 
                  v-model="survey.email" 
                  required
                  :class="{ 'is-invalid': errors.email }"
                >
                <div v-if="errors.email" class="invalid-feedback">{{ errors.email }}</div>
              </div>
            </div>
  
            <!-- Campus Experience -->
            <h3 class="section-title"><i class="fas fa-university me-2"></i>Campus Experience</h3>
            <div class="checkbox-section p-3 mb-4">
              <label class="form-label">What did you like most about the campus? <span class="text-danger">*</span></label>
              <div class="row">
                <div class="col-md-4">
                  <div class="form-check mb-2">
                    <input 
                      class="form-check-input" 
                      type="checkbox" 
                      id="like-students" 
                      value="students" 
                      v-model="survey.likedMost"
                    >
                    <label class="form-check-label" for="like-students">Students</label>
                  </div>
                  <div class="form-check mb-2">
                    <input 
                      class="form-check-input" 
                      type="checkbox" 
                      id="like-location" 
                      value="location" 
                      v-model="survey.likedMost"
                    >
                    <label class="form-check-label" for="like-location">Location</label>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="form-check mb-2">
                    <input 
                      class="form-check-input" 
                      type="checkbox" 
                      id="like-campus" 
                      value="campus" 
                      v-model="survey.likedMost"
                    >
                    <label class="form-check-label" for="like-campus">Campus</label>
                  </div>
                  <div class="form-check mb-2">
                    <input 
                      class="form-check-input" 
                      type="checkbox" 
                      id="like-atmosphere" 
                      value="atmosphere" 
                      v-model="survey.likedMost"
                    >
                    <label class="form-check-label" for="like-atmosphere">Atmosphere</label>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="form-check mb-2">
                    <input 
                      class="form-check-input" 
                      type="checkbox" 
                      id="like-dorms" 
                      value="dorms" 
                      v-model="survey.likedMost"
                    >
                    <label class="form-check-label" for="like-dorms">Dorm Rooms</label>
                  </div>
                  <div class="form-check mb-2">
                    <input 
                      class="form-check-input" 
                      type="checkbox" 
                      id="like-sports" 
                      value="sports" 
                      v-model="survey.likedMost"
                    >
                    <label class="form-check-label" for="like-sports">Sports</label>
                  </div>
                </div>
              </div>
              <div v-if="errors.likedMost" class="text-danger mt-2">{{ errors.likedMost }}</div>
            </div>
  
            <!-- Interest Source -->
            <div class="form-group mb-4">
              <label class="form-label">How did you become interested in the university? <span class="text-danger">*</span></label>
              <div class="radio-section p-3">
                <div class="row">
                  <div class="col-md-3">
                    <div class="form-check">
                      <input 
                        class="form-check-input" 
                        type="radio" 
                        id="interest-friends" 
                        value="friends" 
                        v-model="survey.interestSource"
                        required
                      >
                      <label class="form-check-label" for="interest-friends">Friends</label>
                    </div>
                  </div>
                  <div class="col-md-3">
                    <div class="form-check">
                      <input 
                        class="form-check-input" 
                        type="radio" 
                        id="interest-television" 
                        value="television" 
                        v-model="survey.interestSource"
                      >
                      <label class="form-check-label" for="interest-television">Television</label>
                    </div>
                  </div>
                  <div class="col-md-3">
                    <div class="form-check">
                      <input 
                        class="form-check-input" 
                        type="radio" 
                        id="interest-internet" 
                        value="internet" 
                        v-model="survey.interestSource"
                      >
                      <label class="form-check-label" for="interest-internet">Internet</label>
                    </div>
                  </div>
                  <div class="col-md-3">
                    <div class="form-check">
                      <input 
                        class="form-check-input" 
                        type="radio" 
                        id="interest-other" 
                        value="other" 
                        v-model="survey.interestSource"
                      >
                      <label class="form-check-label" for="interest-other">Other</label>
                    </div>
                  </div>
                </div>
                <div v-if="errors.interestSource" class="text-danger mt-2">{{ errors.interestSource }}</div>
              </div>
            </div>
  
            <!-- Recommendation Likelihood -->
            <div class="mb-4">
              <label for="recommendation" class="form-label">How likely are you to recommend GMU to other prospective students? <span class="text-danger">*</span></label>
              <select 
                class="form-select" 
                id="recommendation" 
                v-model="survey.recommendation" 
                required
                :class="{ 'is-invalid': errors.recommendation }"
              >
                <option value="">Select an option</option>
                <option value="Very Likely">Very Likely</option>
                <option value="Likely">Likely</option>
                <option value="Unlikely">Unlikely</option>
              </select>
              <div v-if="errors.recommendation" class="invalid-feedback">{{ errors.recommendation }}</div>
            </div>
  
            <!-- Additional Comments -->
            <div class="mb-4">
              <label for="comments" class="form-label">Additional Comments</label>
              <textarea 
                class="form-control" 
                id="comments" 
                v-model="survey.comments" 
                rows="4" 
                placeholder="Please share any additional thoughts about your campus visit..."
              ></textarea>
            </div>
  
            <!-- Survey Date -->
            <div class="mb-4">
              <label for="surveyDate" class="form-label">Survey Date <span class="text-danger">*</span></label>
              <input 
                type="date" 
                class="form-control" 
                id="surveyDate" 
                v-model="survey.surveyDate" 
                required
                :class="{ 'is-invalid': errors.surveyDate }"
              >
              <div v-if="errors.surveyDate" class="invalid-feedback">{{ errors.surveyDate }}</div>
            </div>
  
            <!-- Action Buttons -->
            <div class="text-center">
              <router-link to="/surveys" class="btn btn-secondary me-3">
                <i class="fas fa-arrow-left me-2"></i>Cancel
              </router-link>
              <button type="submit" class="btn-submit">
                <i class="fas fa-save me-2"></i>Save Changes
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import SurveyService from '../services/SurveyService';
  
  export default {
    name: 'SurveyEdit',
    props: {
      id: {
        type: String,
        required: true
      }
    },
    data() {
      return {
        survey: {
          firstName: '',
          lastName: '',
          address: '',
          city: '',
          state: '',
          zip: '',
          phoneNumber: '',
          email: '',
          surveyDate: '',
          likedMost: [],
          interestSource: '',
          recommendation: '',
          comments: ''
        },
        loading: true,
        error: null,
        errors: {}
      }
    },
    created() {
      this.fetchSurvey();
    },
    methods: {
      formatDateForInput(dateString) {
        if (!dateString) return '';
        
        const date = new Date(dateString);
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const day = String(date.getDate()).padStart(2, '0');
        
        return `${year}-${month}-${day}`;
      },
      fetchSurvey() {
        this.loading = true;
        this.error = null;
        
        SurveyService.getSurveyById(this.id)
          .then(response => {
            const survey = response.data;
            
            // Format date for HTML date input
            survey.surveyDate = this.formatDateForInput(survey.surveyDate);
            
            this.survey = survey;
            this.loading = false;
          })
          .catch(error => {
            console.error('Error fetching survey:', error);
            this.error = 'Failed to load survey data. The survey may not exist or has been deleted.';
            this.loading = false;
          });
      },
      validateForm() {
        this.errors = {};
        let isValid = true;
  
        // First Name validation
        if (!this.survey.firstName.trim()) {
          this.errors.firstName = 'First name is required';
          isValid = false;
        }
  
        // Last Name validation
        if (!this.survey.lastName.trim()) {
          this.errors.lastName = 'Last name is required';
          isValid = false;
        }
  
        // Address validation
        if (!this.survey.address.trim()) {
          this.errors.address = 'Address is required';
          isValid = false;
        }
  
        // City validation
        if (!this.survey.city.trim()) {
          this.errors.city = 'City is required';
          isValid = false;
        }
  
        // State validation
        if (!this.survey.state.trim()) {
          this.errors.state = 'State is required';
          isValid = false;
        }
  
        // ZIP validation
        if (!this.survey.zip.trim()) {
          this.errors.zip = 'ZIP code is required';
          isValid = false;
        } else if (!/^\d{5}$/.test(this.survey.zip)) {
          this.errors.zip = 'ZIP code must be 5 digits';
          isValid = false;
        }
  
        // Phone validation
        if (!this.survey.phoneNumber.trim()) {
          this.errors.phoneNumber = 'Phone number is required';
          isValid = false;
        } else if (!/^\d{3}-\d{3}-\d{4}$/.test(this.survey.phoneNumber)) {
          this.errors.phoneNumber = 'Phone number must be in format XXX-XXX-XXXX';
          isValid = false;
        }
  
        // Email validation
        if (!this.survey.email.trim()) {
          this.errors.email = 'Email is required';
          isValid = false;
        } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(this.survey.email)) {
          this.errors.email = 'Please enter a valid email address';
          isValid = false;
        }
  
        // Liked Most validation
        if (this.survey.likedMost.length < 2) {
          this.errors.likedMost = 'Please select at least two things you liked about the campus';
          isValid = false;
        }
  
        // Interest Source validation
        if (!this.survey.interestSource) {
          this.errors.interestSource = 'Please select how you became interested in the university';
          isValid = false;
        }
  
        // Recommendation validation
        if (!this.survey.recommendation) {
          this.errors.recommendation = 'Please select your recommendation likelihood';
          isValid = false;
        }
  
        // Survey Date validation
        if (!this.survey.surveyDate) {
          this.errors.surveyDate = 'Survey date is required';
          isValid = false;
        }
  
        return isValid;
      },
      submitForm() {
        if (this.validateForm()) {
          // Format the survey date for backend
          const formattedSurvey = {
            ...this.survey,
            surveyDate: new Date(this.survey.surveyDate)
          };
  
          SurveyService.updateSurvey(this.id, formattedSurvey)
            .then(response => {
              alert(`Survey for ${response.data.firstName} updated successfully!`);
              // Navigate back to surveys list
              this.$router.push({ name: 'surveys' });
            })
            .catch(error => {
              console.error('Error updating survey:', error);
              alert('An error occurred while updating the survey. Please try again.');
            });
        } else {
          // Scroll to the first error
          const firstErrorElement = document.querySelector('.is-invalid');
          if (firstErrorElement) {
            firstErrorElement.scrollIntoView({ behavior: 'smooth', block: 'center' });
            firstErrorElement.focus();
          }
        }
      }
    }
  }
  </script>
  
  <style scoped>
  .header-box {
    border: 5px solid var(--gmu-yellow);
    box-shadow: 0 10px 20px rgba(0,102,51,0.2);
    padding: 20px;
    background-color: var(--gmu-green);
    text-align: center;
    border-radius: 8px;
  }
  
  .header-box h1 {
    color: white;
    margin: 0;
    font-weight: bold;
  }
  
  .section-title {
    color: var(--gmu-green);
    border-bottom: 3px solid var(--gmu-yellow);
    padding-bottom: 10px;
    margin: 30px 0 20px 0;
  }
  
  .checkbox-section, .radio-section {
    background-color: rgba(255, 204, 51, 0.1);
    border-radius: 8px;
    border-left: 4px solid var(--gmu-yellow);
  }
  
  .btn-submit {
    background-color: var(--gmu-green);
    color: white;
    padding: 15px 40px;
    border: 2px solid var(--gmu-yellow);
    border-radius: 30px;
    transition: all 0.3s ease;
  }
  
  .btn-submit:hover {
    background-color: var(--gmu-yellow);
    color: var(--gmu-green);
    transform: translateY(-2px);
    box-shadow: 0 4px 6px rgba(0,102,51,0.2);
  }
  </style>