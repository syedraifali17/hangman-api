# Hangman API

A REST API implementation of the classic Hangman word-guessing game, built with Spring Boot and PostgreSQL.

## Tech Stack

- **Java 17**
- **Spring Boot 4**
- **Spring Security** — endpoint protection and BCrypt password hashing
- **Spring Data JPA / Hibernate** — database ORM
- **PostgreSQL** — relational database (via Docker)
- **Lombok** — boilerplate reduction
- **Maven** — dependency management
- **Docker Compose** — local database setup

## Features

- User registration and login with BCrypt password hashing
- Game session management — one active game per user at a time
- Word database with 50 words across 10 categories, each with two progressive hints
- Hint system — first hint at 3 wrong guesses, second hint at 5 wrong guesses
- Win/loss detection with automatic game session status updates
- Streak tracking — current streak resets on loss, highest streak is permanent
- Leaderboard sorted by highest streak
- Global exception handling with consistent JSON error responses
- Bean Validation on all request DTOs

## Project Structure
```
src/main/java/com/raif/hangman_api/
├── config/         # Security and password encoder configuration
├── controller/     # REST endpoints
├── dto/            # Request and response data transfer objects
├── entity/         # JPA entities (database tables)
├── exception/      # Custom exceptions and global exception handler
├── repository/     # Spring Data JPA repositories
└── service/        # Business logic
```

## Getting Started

### Prerequisites

- Java 17+
- Docker Desktop
- Maven

### Setup

1. Clone the repository
```bash
git clone https://github.com/syedraifali17/hangman-api.git
cd hangman-api
```

2. Copy the example properties file and fill in your values
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

3. Start the PostgreSQL database
```bash
docker-compose up -d
```

4. Run the application
```bash
./mvnw spring-boot:run
```

The app will start on `http://localhost:8080` and automatically seed the word database on first run.

## API Endpoints

### Auth
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Login with username and password |

### Game
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/game/start` | Start a new game session |
| GET | `/api/game/status?userId={id}` | Get current game state |
| POST | `/api/game/guess` | Submit a letter guess |

### Stats
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/stats/me?userId={id}` | Get your stats |
| GET | `/api/stats/leaderboard` | Get all users sorted by highest streak |

### Words
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/words/random` | Get a random word |
| GET | `/api/words/category/{category}` | Get words by category |
| GET | `/api/words/count` | Get total word count |

## Example Game Flow

**1. Register**
```json
POST /api/auth/register
{"username": "raif", "password": "secret123"}
```

**2. Start a game**
```json
POST /api/game/start
{"userId": 1}

Response:
{
  "sessionId": 1,
  "maskedWord": "_ _ _ _ _ _ _ _",
  "wordLength": 8,
  "wrongGuesses": 0,
  "maxWrongGuesses": 6,
  "guessedLetters": "",
  "status": "ACTIVE",
  "hint1": "It is the largest land animal",
  "hint2": "It has a long trunk",
  "category": "Animals"
}
```

**3. Guess a letter**
```json
POST /api/game/guess
{"userId": 1, "letter": "e"}

Response:
{
  "result": "CORRECT",
  "maskedWord": "e _ e _ _ _ _ _",
  "wrongGuesses": 0,
  "maxWrongGuesses": 6,
  "guessedLetters": "e",
  "status": "ACTIVE",
  "hint": null,
  "actualWord": null
}
```

## Word Categories

Animals, Food, Music, Technology, Nature, Science, Sports, Places, Objects, Professions, History, Education

## Author

Syed Raif Ali — [GitHub](https://github.com/syedraifali17)