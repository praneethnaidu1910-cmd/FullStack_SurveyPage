package edu.gmu.swe642.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.gmu.swe642.model.Survey;

/**
 * Repository interface for Survey entity
 * Provides CRUD operations for Survey entities
 */
@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    // Additional custom query methods can be added here if needed
}