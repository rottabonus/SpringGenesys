/*
CREATE DATABASE ohjelmistoprojekti
CHARACTER SET utf8;

GRANT ALL ON ohjelmistoprojekti.* TO 'java'@'localhost' IDENTIFIED by 'password';
*/

CREATE TABLE team (
team_id int NOT NULL AUTO_INCREMENT,
team_name varchar(1000) NOT NULL,
PRIMARY KEY (team_id)
);

CREATE TABLE question (
question_id int NOT NULL AUTO_INCREMENT,
question varchar(1000) NOT NULL,
question_type varchar(10000) NOT NULL,
team_id int,
PRIMARY KEY (question_id),
FOREIGN KEY (team_id) REFERENCES team(team_id)
);

CREATE TABLE answer (
answer_id int NOT NULL AUTO_INCREMENT,
answer varchar(10000),
question_id int,
PRIMARY KEY (answer_id),
FOREIGN KEY (question_id) REFERENCES question(question_id)
);

