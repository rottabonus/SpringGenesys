package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class QuestionType {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long question_type_id;

private String question_type;

@OneToMany(cascade = CascadeType.ALL, mappedBy = "question_type")
@JsonIgnore
public List<Question>  question_list;

public QuestionType(String question_type, List<Question> question_list) {
	super();
	this.question_type = question_type;
	this.question_list = question_list;
}



public Long getQuestion_type_id() {
	return question_type_id;
}

public void setQuestion_type_id(Long question_type_id) {
	this.question_type_id = question_type_id;
}

public String getQuestion_type() {
	return question_type;
}

public void setQuestion_type(String question_type) {
	this.question_type = question_type;
}

public List<Question> getQuestion_list() {
	return question_list;
}

public void setQuestion_list(List<Question> question_list) {
	this.question_list = question_list;
}

public QuestionType() {}





}