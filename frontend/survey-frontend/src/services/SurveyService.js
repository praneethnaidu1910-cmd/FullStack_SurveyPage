/**
 * Survey service for making API calls to the backend
 */
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/surveys';

class SurveyService {
  /**
   * Get all surveys
   * @returns {Promise<Array>} All surveys
   */
  getAllSurveys() {
    return axios.get(API_URL);
  }

  /**
   * Get survey by ID
   * @param {number} id Survey ID
   * @returns {Promise<Object>} Survey data
   */
  getSurveyById(id) {
    return axios.get(`${API_URL}/${id}`);
  }

  /**
   * Create a new survey
   * @param {Object} survey Survey data
   * @returns {Promise<Object>} Created survey
   */
  createSurvey(survey) {
    return axios.post(API_URL, survey);
  }

  /**
   * Update an existing survey
   * @param {number} id Survey ID
   * @param {Object} survey Updated survey data
   * @returns {Promise<Object>} Updated survey
   */
  updateSurvey(id, survey) {
    return axios.put(`${API_URL}/${id}`, survey);
  }

  /**
   * Delete a survey
   * @param {number} id Survey ID
   * @returns {Promise<void>}
   */
  deleteSurvey(id) {
    return axios.delete(`${API_URL}/${id}`);
  }
}

export default new SurveyService();