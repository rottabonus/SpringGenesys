/*
CREATE DATABASE ohjelmistoprojekti CHARACTER SET utf8;
GRANT ALL ON ohjelmistoprojekti.* TO 'java'@'localhost' IDENTIFIED by 'password';
*/

CREATE TABLE question_type (
question_type_id INT NOT NULL AUTO_INCREMENT,
question_type VARCHAR(1000) NOT NULL,
PRIMARY KEY (question_type_id)
);

CREATE TABLE survey (
survey_id INT NOT NULL AUTO_INCREMENT,
survey_name VARCHAR(1000) NOT NULL,
PRIMARY KEY (survey_id)
);

CREATE TABLE question (
question_id INT NOT NULL AUTO_INCREMENT,
question_type_id INT,
question VARCHAR(10000) NOT NULL,
survey_id INT,
PRIMARY KEY (question_id),
FOREIGN KEY (question_type_id) REFERENCES question_type(question_type_id),
FOREIGN KEY (survey_id) REFERENCES survey(survey_id)
);

CREATE TABLE text_answer (
text_answer_id INT NOT NULL AUTO_INCREMENT,
text_answer VARCHAR(10000) NOT NULL,
question_id INT,
PRIMARY KEY (text_answer_id),
FOREIGN KEY (question_id) REFERENCES question(question_id)
);

CREATE TABLE answer_option (
answer_option_id INT NOT NULL AUTO_INCREMENT,
question_id INT,
answer_option VARCHAR(10000) NOT NULL,
PRIMARY KEY (answer_option_id),
FOREIGN KEY (question_id) REFERENCES question(question_id)
);

CREATE TABLE choice_answer (
choice_answer_id INT NOT NULL AUTO_INCREMENT,
answer_option_id INT,
PRIMARY KEY (choice_answer_id),
FOREIGN KEY (answer_option_id) REFERENCES answer_option(answer_option_id)
);
