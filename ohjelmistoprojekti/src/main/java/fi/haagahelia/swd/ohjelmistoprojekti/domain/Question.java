package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import java.util.List;

import javax.persistence.CascadeType;
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

@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
@JsonIgnore
private List<Answer> answer_list;

@ManyToOne
@JsonIgnore
@JoinColumn(name="team_id")
private Team team;

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
	return team;
}

public void setTeam_id(Team team) {
	this.team = team;
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


public Question(String question, String question_type, List<Answer> answer_list, Team team) {
	super();
	this.question = question;
	this.question_type = question_type;
	this.answer_list = answer_list;
	this.team = team;
}

public Question() {
	super();
	this.question = null;
	this.question_type = null;
	this.answer_list = null;
	this.team = null;
}




	}
