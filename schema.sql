CREATE TABLE questions (
  id INT NOT NULL AUTO_INCREMENT,
  text TEXT NOT NULL,
  correct_answer_index INT NOT NULL,
  quiz_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_questions_quiz
    FOREIGN KEY (quiz_id)
    REFERENCES quizzes (id)
    ON DELETE CASCADE,
  CHECK (correct_answer_index BETWEEN 0 AND 3)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;
