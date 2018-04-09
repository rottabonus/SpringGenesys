CREATE TABLE team (
team_id int NOT NULL AUTO_INCREMENT,
team_name varchar(1000) NOT NULL,
PRIMARY KEY (team_id)
);

CREATE TABLE answer (
answer_id int NOT NULL AUTO_INCREMENT,
answer varchar(10000),
PRIMARY KEY (answer_id)
);

CREATE TABLE question (
id int NOT NULL AUTO_INCREMENT,
question varchar(1000) NOT NULL,
team_id int,
answer_id int,
PRIMARY KEY (id),
FOREIGN KEY (team_id) REFERENCES team(team_id),
FOREIGN KEY (answer_id) REFERENCES answer(answer_id)
);

