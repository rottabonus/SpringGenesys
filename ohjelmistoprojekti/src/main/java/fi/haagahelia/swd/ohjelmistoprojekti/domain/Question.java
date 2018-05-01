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

@ManyToOne
@JoinColumn(name="question_type_id")
private QuestionType question_type;

private String question;

@ManyToOne
@JoinColumn(name="survey_id")
private Survey survey;

@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
@JsonIgnore
private List<AnswerOption> option_list;

@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
@JsonIgnore
private List<TextAnswer> answer_list;

public Survey getSurvey() {
	return survey;
}

public void setSurvey(Survey survey) {
	this.survey = survey;
}

public List<AnswerOption> getOption_list() {
	return option_list;
}

public void setOption_list(List<AnswerOption> option_list) {
	this.option_list = option_list;
}

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




public List<TextAnswer> getAnswer_list() {
	return answer_list;
}

public void setAnswer_list(List<TextAnswer> answer_list) {
	this.answer_list = answer_list;
}

public QuestionType getQuestion_type() {
	return question_type;
}

public void setQuestion_type(QuestionType question_type) {
	this.question_type = question_type;
}

public Question(String question, QuestionType question_type, List<TextAnswer> answer_list, Survey survey,
		List<AnswerOption> option_list) {
	super();
	this.question = question;
	this.question_type = question_type;
	this.answer_list = answer_list;
	this.survey = survey;
	this.option_list = option_list;
}

public Question() {}







	}
