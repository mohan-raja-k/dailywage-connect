# DailyWage Connect 🔨

AI-powered platform connecting daily wage workers to employers directly.
Eliminates middlemen and helps 40 crore daily wage workers in India find work easily.

## Tech Stack
- Java 21 + Spring Boot 3.5
- REST APIs
- H2 Database
- Spring Security
- Lombok

## Modules
- User Management (Worker/Employer/Admin)
- Job Management
- Application Management
- Rating System

## API Endpoints
| Method | URL | Description |
|---|---|---|
| POST | /User/addUser | Add new user |
| GET | /User/getUserByCity | Search by city |
| POST | /Job/addJob | Post a job |
| GET | /Job/getJobByLocation | Search jobs by location |
| POST | /Application/addApplication | Apply for job |
| GET | /Rating/getAverageRatingScore | Get worker rating |
