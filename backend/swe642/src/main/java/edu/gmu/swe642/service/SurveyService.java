package edu.gmu.swe642.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.gmu.swe642.model.Survey;
import edu.gmu.swe642.repository.SurveyRepository;

/**
 * Service class for Survey entity
 * Contains business logic for survey operations
 */
@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;

    
    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    /**
     * Get all surveys
     * @return List of all surveys
     */
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    /**
     * Get survey by ID
     * @param id Survey ID
     * @return Optional containing the survey if found
     */
    public Optional<Survey> getSurveyById(Long id) {
        return surveyRepository.findById(id);
    }

    /**
     * Save a new survey
     * @param survey Survey to save
     * @return Saved survey with ID
     */
    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    /**
     * Update an existing survey
     * @param id Survey ID
     * @param updatedSurvey Updated survey data
     * @return Updated survey
     * @throws RuntimeException if survey not found
     */
    public Survey updateSurvey(Long id, Survey updatedSurvey) {
        return surveyRepository.findById(id)
                .map(survey -> {
                    survey.setFirstName(updatedSurvey.getFirstName());
                    survey.setLastName(updatedSurvey.getLastName());
                    survey.setAddress(updatedSurvey.getAddress());
                    survey.setCity(updatedSurvey.getCity());
                    survey.setState(updatedSurvey.getState());
                    survey.setZip(updatedSurvey.getZip());
                    survey.setPhoneNumber(updatedSurvey.getPhoneNumber());
                    survey.setEmail(updatedSurvey.getEmail());
                    survey.setSurveyDate(updatedSurvey.getSurveyDate());
                    survey.setLikedMost(updatedSurvey.getLikedMost());
                    survey.setInterestSource(updatedSurvey.getInterestSource());
                    survey.setRecommendation(updatedSurvey.getRecommendation());
                    survey.setComments(updatedSurvey.getComments());
                    return surveyRepository.save(survey);
                })
                .orElseThrow(() -> new RuntimeException("Survey not found with id " + id));
    }

    /**
     * Delete a survey by ID
     * @param id Survey ID
     */
    public void deleteSurvey(Long id) {
        surveyRepository.deleteById(id);
    }
}