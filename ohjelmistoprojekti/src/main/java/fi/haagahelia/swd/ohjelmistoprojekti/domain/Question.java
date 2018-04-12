package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long question_id;
private String question;
private String question_type;

@OneToMany
@JsonIgnore
@JoinColumn(name="answer_id", nullable=false)
private List<Answer> answer_list;

@ManyToOne
@JoinColumn(name="team_id", nullable=false)
private Team team_id;

public Long getQuestion_id() {
	return question_id;
}

public void setQuestion_id(Long question_id) {
	this.question_id = question_id;
}

public String getQuestion() {
	return question;
}

public void setQuestion(String question) {
	this.question = question;
}

public Team getTeam_id() {
	return team_id;
}

public void setTeam_id(Team team_id) {
	this.team_id = team_id;
}

public String getQuestion_type() {
	return question_type;
}

public void setQuestion_type(String question_type) {
	this.question_type = question_type;
}

public List<Answer> getAnswer_list() {
	return answer_list;
}

public void setAnswer_list(List<Answer> answer_list) {
	this.answer_list = answer_list;
}

public Question() {
	super();
}

public Question(String question, String question_type, List<Answer> answer_list, Team team_id) {
	super();
	this.question = question;
	this.question_type = question_type;
	this.answer_list = answer_list;
	this.team_id = team_id;
}




	}
