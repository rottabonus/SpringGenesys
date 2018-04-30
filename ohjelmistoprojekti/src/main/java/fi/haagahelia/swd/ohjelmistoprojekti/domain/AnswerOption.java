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
	private Long answer_option_id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="choice_answer_id")
	private ChoiceAnswer choice_answer;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "question_id")
	private Question question;
	

	public Long getAnswer_option_id() {
		return answer_option_id;
	}

	public void setAnswer_option_id(Long answer_option_id) {
		this.answer_option_id = answer_option_id;
	}

	public ChoiceAnswer getChoice_answer() {
		return choice_answer;
	}

	public void setChoice_answer(ChoiceAnswer choice_answer) {
		this.choice_answer = choice_answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public AnswerOption(ChoiceAnswer choice_answer, Question question) {
		super();
		this.choice_answer = choice_answer;
		this.question = question;
	}

	public AnswerOption() {}

	
}
