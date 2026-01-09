<template>
    <div class="survey-list">
      <div class="header-box mb-4">
        <h1><i class="fas fa-list-ul me-2"></i>All Surveys</h1>
      </div>
      
      <div class="card shadow-sm">
        <div class="card-body">
          <div v-if="loading" class="text-center my-5">
            <div class="spinner-border text-primary" role="status">
              <span class="visually-hidden">Loading...</span>
            </div>
            <p class="mt-2">Loading surveys...</p>
          </div>
          
          <div v-else-if="error" class="alert alert-danger" role="alert">
            <i class="fas fa-exclamation-triangle me-2"></i>{{ error }}
          </div>
          
          <div v-else-if="surveys.length === 0" class="alert alert-info" role="alert">
            <i class="fas fa-info-circle me-2"></i>No surveys have been submitted yet.
            <div class="mt-3">
              <router-link to="/survey" class="btn btn-primary">Create a Survey</router-link>
            </div>
          </div>
          
          <div v-else>
            <div class="d-flex justify-content-between align-items-center mb-4">
              <h3 class="mb-0">Survey Submissions</h3>
              <router-link to="/survey" class="btn btn-success">
                <i class="fas fa-plus me-2"></i>New Survey
              </router-link>
            </div>
            
            <div class="table-responsive">
              <table class="table table-hover">
                <thead class="table-light">
                  <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Date</th>
                    <th>Recommendation</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="(survey, index) in surveys" :key="survey.id">
                    <td>{{ index + 1 }}</td>
                    <td>{{ survey.firstName }} {{ survey.lastName }}</td>
                    <td>{{ survey.email }}</td>
                    <td>{{ formatDate(survey.surveyDate) }}</td>
                    <td>
                      <span :class="getRecommendationBadgeClass(survey.recommendation)">
                        {{ survey.recommendation }}
                      </span>
                    </td>
                    <td>
                      <div class="btn-group">
                        <button class="btn btn-sm btn-info me-2" @click="viewSurveyDetails(survey)">
                          <i class="fas fa-eye me-1"></i>View
                        </button>
                        <router-link :to="{ name: 'survey-edit', params: { id: survey.id }}" class="btn btn-sm btn-primary me-2">
                          <i class="fas fa-edit me-1"></i>Edit
                        </router-link>
                        <button class="btn btn-sm btn-danger" @click="confirmDelete(survey)">
                          <i class="fas fa-trash-alt me-1"></i>Delete
                        </button>
                      </div>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          
          <!-- Survey Details Modal -->
          <div class="modal fade" id="surveyDetailsModal" tabindex="-1" aria-labelledby="surveyDetailsModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
              <div class="modal-content">
                <div class="modal-header" style="background-color: var(--gmu-green); color: white;">
                  <h5 class="modal-title" id="surveyDetailsModalLabel">Survey Details</h5>
                  <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body" v-if="selectedSurvey">
                  <div class="row">
                    <div class="col-md-6 mb-3">
                      <h6 class="text-muted">Personal Information</h6>
                      <p><strong>Name:</strong> {{ selectedSurvey.firstName }} {{ selectedSurvey.lastName }}</p>
                      <p><strong>Address:</strong> {{ selectedSurvey.address }}</p>
                      <p><strong>City:</strong> {{ selectedSurvey.city }}</p>
                      <p><strong>State:</strong> {{ selectedSurvey.state }}</p>
                      <p><strong>ZIP:</strong> {{ selectedSurvey.zip }}</p>
                      <p><strong>Phone:</strong> {{ selectedSurvey.phoneNumber }}</p>
                      <p><strong>Email:</strong> {{ selectedSurvey.email }}</p>
                    </div>
                    <div class="col-md-6 mb-3">
                      <h6 class="text-muted">Survey Responses</h6>
                      <p><strong>Survey Date:</strong> {{ formatDate(selectedSurvey.surveyDate) }}</p>
                      <p><strong>Liked Most:</strong> {{ selectedSurvey.likedMost.join(', ') }}</p>
                      <p><strong>Interest Source:</strong> {{ selectedSurvey.interestSource }}</p>
                      <p><strong>Recommendation:</strong> {{ selectedSurvey.recommendation }}</p>
                      <p><strong>Comments:</strong> {{ selectedSurvey.comments || 'No comments provided' }}</p>
                    </div>
                  </div>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                  <router-link v-if="selectedSurvey" :to="{ name: 'survey-edit', params: { id: selectedSurvey.id }}" class="btn btn-primary">
                    <i class="fas fa-edit me-1"></i>Edit
                  </router-link>
                  <button v-else class="btn btn-secondary" disabled>
                   <i class="fas fa-edit me-1"></i>Edit
                  </button>
                </div>
              </div>
            </div>
          </div>
          
          <!-- Delete Confirmation Modal -->
          <div class="modal fade" id="deleteConfirmModal" tabindex="-1" aria-labelledby="deleteConfirmModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header bg-danger text-white">
                  <h5 class="modal-title" id="deleteConfirmModalLabel">Confirm Delete</h5>
                  <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body" v-if="selectedSurvey">
                  <p>Are you sure you want to delete the survey from <strong>{{ selectedSurvey.firstName }} {{ selectedSurvey.lastName }}</strong>?</p>
                  <p class="text-danger"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                  <button type="button" class="btn btn-danger" @click="deleteSurvey">Delete</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import SurveyService from '../services/SurveyService';
  import { Modal } from 'bootstrap';
  
  export default {
    name: 'SurveyList',
    data() {
      return {
        surveys: [],
        loading: true,
        error: null,
        selectedSurvey: null,
        surveyDetailsModal: null,
        deleteConfirmModal: null
      }
    },
    created() {
      this.fetchSurveys();
    },
    mounted() {
      // Initialize modals
      this.surveyDetailsModal = new Modal(document.getElementById('surveyDetailsModal'));
      this.deleteConfirmModal = new Modal(document.getElementById('deleteConfirmModal'));
    },
    methods: {
      fetchSurveys() {
        this.loading = true;
        this.error = null;
        
        SurveyService.getAllSurveys()
          .then(response => {
            this.surveys = response.data;
            this.loading = false;
          })
          .catch(error => {
            console.error('Error fetching surveys:', error);
            this.error = 'Failed to load surveys. Please try again later.';
            this.loading = false;
          });
      },
      formatDate(dateString) {
        if (!dateString) return 'N/A';
        
        const date = new Date(dateString);
        return date.toLocaleDateString('en-US', {
          year: 'numeric',
          month: 'short',
          day: 'numeric'
        });
      },
      getRecommendationBadgeClass(recommendation) {
        switch (recommendation) {
          case 'Very Likely':
            return 'badge bg-success';
          case 'Likely':
            return 'badge bg-info';
          case 'Unlikely':
            return 'badge bg-warning text-dark';
          default:
            return 'badge bg-secondary';
        }
      },
      viewSurveyDetails(survey) {
        this.selectedSurvey = survey;
        this.surveyDetailsModal.show();
      },
      confirmDelete(survey) {
        this.selectedSurvey = survey;
        this.deleteConfirmModal.show();
      },
      deleteSurvey() {
        if (!this.selectedSurvey) return;
        
        SurveyService.deleteSurvey(this.selectedSurvey.id)
          .then(() => {
            // Remove from local list
            this.surveys = this.surveys.filter(s => s.id !== this.selectedSurvey.id);
            // Close modal
            this.deleteConfirmModal.hide();
            // Show success message
            alert('Survey deleted successfully!');
          })
          .catch(error => {
            console.error('Error deleting survey:', error);
            alert('Failed to delete the survey. Please try again.');
          });
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
  
  .table th {
    background-color: var(--gmu-green);
    color: white;
    border-color: #004d26;
  }
  
  .table tbody tr:hover {
    background-color: rgba(255, 204, 51, 0.1);
  }
  
  .btn-group .btn {
    margin-right: 5px;
  }
  </style>