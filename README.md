# Campus Survey Platform

A full-stack survey management web application featuring a Vue.js SPA frontend and Spring Boot RESTful backend, deployed on AWS EC2 and S3.

## What It Does

Users can submit, view, edit, and delete campus surveys through a responsive single-page application. The system handles full CRUD operations with client-side validation, centralized state management, and a layered backend architecture.

## Tech Stack

**Frontend**
- Vue.js 3 with Vuex (state management) and Vue Router
- Axios for API communication
- Bootstrap 5 for responsive UI

**Backend**
- Spring Boot 2.7 / Java 17
- JPA / Hibernate ORM
- MySQL database

**Infrastructure**
- Deployed on AWS EC2 (backend) and AWS S3 (static frontend)

## Architecture

Client-server SPA pattern with clear separation of concerns:
- **Frontend**: Component-based Vue.js with Vuex for predictable state transitions
- **Backend**: Layered Spring Boot — Controller → Service → Repository → Model

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/surveys | Retrieve all surveys |
| GET | /api/surveys/{id} | Retrieve survey by ID |
| POST | /api/surveys | Create new survey |
| PUT | /api/surveys/{id} | Update existing survey |
| DELETE | /api/surveys/{id} | Delete survey |

## Setup

**Backend**
```bash
cd backend/swe642
mvn spring-boot:run
```

Configure MySQL in `src/main/resources/application.properties` before running.

**Frontend**
```bash
cd frontend/survey-frontend
npm install
npm run serve
```

Frontend communicates with backend at `http://localhost:8080`.

## Key Features

- **Form validation** — Required fields, email format, phone (XXX-XXX-XXXX), ZIP code (5-digit)
- **Responsive design** — Mobile-friendly Bootstrap 5 grid with collapsible navigation
- **Reusable components** — Custom Alert and Confirmation Dialog components
- **State management** — Vuex actions, mutations, and getters for predictable data flow

## Future Work

- Real-time seat availability updates via WebSockets
- Email confirmation on survey submission using Resend API
- Docker containerization for one-command local setup
