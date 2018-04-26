package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AnswerOption {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long option_id;
	
	private String option;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "question_id")
	private Question question;
	
	

	public Long getOption_id() {
		return option_id;
	}

	public void setOption_id(Long option_id) {
		this.option_id = option_id;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public AnswerOption(String option, Question question) {
		super();
		this.option = option;
		this.question = question;
	}

	public AnswerOption() {}

	
}
