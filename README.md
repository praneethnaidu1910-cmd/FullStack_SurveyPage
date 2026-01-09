
# Campus Survey Application (Vue.js + Spring Boot)

This project is a full-stack Student Survey management system developed as part of **SWE 642: Software Engineering for the World Wide Web** at George Mason University. It features a responsive Single Page Application (SPA) frontend built with **Vue.js** and a robust **Spring Boot** RESTful backend.

## 🚀 Project Overview

The application allows users to submit, view, edit, and delete campus surveys. It builds on previous assignments to demonstrate proficiency in modern web technologies, including centralized state management, layered backend architecture, and database persistence.

## 🛠️ Tech Stack

Frontend 

* **Framework:** Vue.js 3
* **State Management:** Vuex
* **Routing:** Vue Router
* **HTTP Client:** Axios
* **Styling:** Bootstrap 5 & Font Awesome

Backend 

* **Framework:** Spring Boot 2.7
* **Language:** Java 17
* **ORM:** JPA / Hibernate
* **Database:** MySQL

🏗️ System Architecture 

The application follows a client-server architecture with a clear separation of concerns:

* 
**Frontend (Vue.js):** Built with a component-based architecture following the SPA pattern. It uses Vuex for centralized state management and Axios for API communication.


* 
**Backend (Spring Boot):** Follows a layered pattern: **Controller** (REST endpoints), **Service** (Business logic), **Repository** (JPA data access), and **Model** (Entity classes).



📡 API Endpoints 

The backend exposes the following RESTful endpoints for CRUD operations:

| Method | Endpoint | Status Code | Description |
| --- | --- | --- | --- |
| `GET` | `/api/surveys` | 200 | Retrieve all surveys |
| `GET` | `/api/surveys/{id}` | 200, 404 | Retrieve a specific survey by ID |
| `POST` | `/api/surveys` | 201 | Create a new survey |
| `PUT` | `/api/surveys/{id}` | 200, 404 | Update an existing survey |
| `DELETE` | `/api/surveys/{id}` | 204, 404 | Delete a survey |

## 🔧 Installation & Setup

Prerequisites 

* Java 17
* Node.js & npm
* Maven
* MySQL

### Backend Setup

1. Navigate to the backend directory.
2. Configure your MySQL database in `src/main/resources/application.properties`.
3. The Survey entity is mapped to the `surveys` table, with a collection table `survey_likes` for storing user preferences.


4. Run the application using Maven:
```bash
mvn spring-boot:run

```



### Frontend Setup

1. Navigate to the `survey-app-vue` directory.
2. Install dependencies:
```bash
npm install

```


3. Run the development server:
```bash
npm run serve

```



Note: The frontend is configured to communicate with the backend at `http://localhost:8080`.



## ✨ Key Features

* 
**Form Validation:** Client-side validation for required fields, email format, phone numbers (XXX-XXX-XXXX), and 5-digit ZIP codes.


* 
**Responsive Design:** Fully mobile-responsive UI using the Bootstrap 5 grid system and collapsible navigation.


* 
**State Management:** Predictable state transitions using Vuex actions, mutations, and getters.


* 
**Reusable Components:** Custom components for Alert Messages and Confirmation Dialogs to improve user experience.



👥 Contributors 
* **Praneeth Naidu**
* **Sri Bhuvan Maddipudi**
* **Ankit Raut**
* **Shreyas Patil**

