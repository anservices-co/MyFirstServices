# Java Spring Boot Quiz Application

This is a simple in-memory quiz application built with Spring Boot.

Endpoints:
- GET /api/questions  - returns the list of questions (without correct answers)
- POST /api/submit    - submit answers as JSON array and receive score

Build & Run:
- Requirements: Java 17+, Maven
- Build: `mvn -q -DskipTests package`
- Run: `mvn spring-boot:run` or run the generated jar `java -jar target/my-first-services-0.0.1-SNAPSHOT.jar`

Example submit payload (POST /api/submit with Content-Type: application/json):

```
[
  { "questionId": 1, "selectedIndex": 2 },
  { "questionId": 2, "selectedIndex": 0 }
]
```

Response example:

```
{ "total": 3, "correct": 2 }
This is a new line
```
