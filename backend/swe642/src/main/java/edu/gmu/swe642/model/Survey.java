package edu.gmu.swe642.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Survey entity class for storing student survey data
 * This class maps to the survey table in the database
 */
@Entity
@Table(name = "surveys")
public class Survey {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private String city;
    
    @Column(nullable = false)
    private String state;
    
    @Column(nullable = false)
    private String zip;
    
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    
    @Column(nullable = false)
    private String email;
    
    @Column(name = "survey_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date surveyDate;
    
    @ElementCollection
    @CollectionTable(name = "survey_likes", joinColumns = @JoinColumn(name = "survey_id"))
    @Column(name = "liked_item")
    private List<String> likedMost;
    
    @Column(name = "interest_source", nullable = false)
    private String interestSource;
    
    @Column(name = "recommendation", nullable = false)
    private String recommendation;
    
    @Column(name = "comments")
    private String comments;
    
    // Default constructor required by JPA
    public Survey() {
    }
    
    // Constructor with fields
    public Survey(String firstName, String lastName, String address, String city, String state, String zip,
                 String phoneNumber, String email, Date surveyDate, List<String> likedMost,
                 String interestSource, String recommendation, String comments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.surveyDate = surveyDate;
        this.likedMost = likedMost;
        this.interestSource = interestSource;
        this.recommendation = recommendation;
        this.comments = comments;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(Date surveyDate) {
        this.surveyDate = surveyDate;
    }

    public List<String> getLikedMost() {
        return likedMost;
    }

    public void setLikedMost(List<String> likedMost) {
        this.likedMost = likedMost;
    }

    public String getInterestSource() {
        return interestSource;
    }

    public void setInterestSource(String interestSource) {
        this.interestSource = interestSource;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", surveyDate=" + surveyDate +
                ", likedMost=" + likedMost +
                ", interestSource='" + interestSource + '\'' +
                ", recommendation='" + recommendation + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}