# Quiz App (Java + MySQL)

A console-based Quiz Application written in **Java**, backed by a **MySQL** database.
The project demonstrates core backend concepts such as database persistence, repository abstraction, and quiz session management.

---

## Features

* Store quizzes, questions, and answer options in a MySQL database
* Load quiz questions dynamically from the database
* Run interactive quiz sessions in the console
* Track user progress and validate answers
* Separation of concerns using repository and service layers

---

## Project Structure

```
quizz_app/
│
├── Main.java
├── Quiz.java
├── Question.java
├── QuizSession.java
├── QuizService.java
├── QuizCreate.java
├── MySqlQuestionRepository.java
```

### File Overview

* **Main.java**
  Application entry point. Establishes database connection and starts a quiz session.

* **Quiz.java**
  Represents a quiz containing a list of questions.

* **Question.java**
  Domain model for a question, including text, options, and correct answer index.

* **QuizSession.java**
  Manages quiz flow, current question index, and user interaction.

* **QuizService.java**
  Contains business logic (e.g., checking if the quiz is finished).

* **MySqlQuestionRepository.java**
  Handles database access and retrieves questions by quiz ID using JDBC.

* **QuizCreate.java**
  Utility class for creating quizzes, questions, and options in the database.

---

## Database Design

The application expects the following tables (simplified):

* `quizzes`
* `questions`
* `options`

Each question belongs to a quiz, and each option belongs to a question.

---

## Prerequisites

* Java 17+ (or Java 11+)
* MySQL Server
* MySQL JDBC Driver
* Git

---

## Setup Instructions

1. **Clone the repository**

   ```bash
   git clone https://github.com/your-username/quiz-app.git
   cd quiz-app
   ```

2. **Create the database**

   ```sql
   CREATE DATABASE QuizApp;
   ```

3. **Update database credentials**

   In `Main.java`, update:

   ```java
   String url = "jdbc:mysql://127.0.0.1:3306/QuizApp";
   String username = "root";
   String password = "your_password";
   ```

4. **Run the application**

   ```bash
   javac quizz_app/*.java
   java quizz_app.Main
   ```

---

## Example Usage

* The quiz questions are loaded from the database
* Questions are displayed one by one
* User answers using letters: `A`, `B`, `C`, or `D`
* The session continues until all questions are answered

---

## Concepts Demonstrated

* JDBC and prepared statements
* Repository pattern
* Object-oriented design
* Separation of domain, service, and persistence layers
* Console-based user interaction

---

## Future Improvements

* Score tracking and result summary
* Multiple quizzes selection
* Input validation and error handling
* Unit tests
* GUI or web interface (Spring Boot)

---

## License

This project is intended for educational purposes.

---

## Author
Maksym Luhin
