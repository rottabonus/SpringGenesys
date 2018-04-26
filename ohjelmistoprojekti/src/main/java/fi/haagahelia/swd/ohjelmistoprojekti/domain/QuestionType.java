package fi.haagahelia.swd.ohjelmistoprojekti.domain;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class QuestionType {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long questionId;

private String questionType;


@ManyToOne
@JsonIgnore
@JoinColumn(name="question")
private Question question;


public QuestionType(Long questionId, String questionType, Question question) {
	super();
	this.questionId = questionId;
	this.questionType = questionType;
	this.question = question;
}


public Long getQuestionId() {
	return questionId;
}


public void setQuestionId(Long questionId) {
	this.questionId = questionId;
}


public String getQuestionType() {
	return questionType;
}


public void setQuestionType(String questionType) {
	this.questionType = questionType;
}


public Question getQuestion() {
	return question;
}


public void setQuestion(Question question) {
	this.question = question;
}


@Override
public String toString() {
	return "QuestionType [questionId=" + questionId + ", questionType=" + questionType + ", question=" + question + "]";
}



}