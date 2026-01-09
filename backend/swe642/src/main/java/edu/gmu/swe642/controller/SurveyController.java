package edu.gmu.swe642.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.gmu.swe642.model.Survey;
import edu.gmu.swe642.service.SurveyService;

/**
 * REST Controller for Survey operations
 * Handles API endpoints for CRUD operations
 */
@RestController
@RequestMapping("/api/surveys")
@CrossOrigin(origins = "http://localhost:8081") // Allow requests from Vue frontend
public class SurveyController {

    private final SurveyService surveyService;

    
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    /**
     * Get all surveys
     * @return List of all surveys
     */
    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys() {
        List<Survey> surveys = surveyService.getAllSurveys();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    /**
     * Get a survey by ID
     * @param id Survey ID
     * @return Survey if found, 404 otherwise
     */
    @GetMapping("/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Long id) {
        return surveyService.getSurveyById(id)
                .map(survey -> new ResponseEntity<>(survey, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Create a new survey
     * @param survey Survey data
     * @return Created survey
     */
    @PostMapping
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) {
        Survey savedSurvey = surveyService.saveSurvey(survey);
        return new ResponseEntity<>(savedSurvey, HttpStatus.CREATED);
    }

    /**
     * Update an existing survey
     * @param id Survey ID
     * @param survey Updated survey data
     * @return Updated survey
     */
    @PutMapping("/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable Long id, @RequestBody Survey survey) {
        try {
            Survey updatedSurvey = surveyService.updateSurvey(id, survey);
            return new ResponseEntity<>(updatedSurvey, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a survey
     * @param id Survey ID
     * @return No content on success
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        surveyService.deleteSurvey(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}