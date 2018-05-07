package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ChoiceAnswer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long choice_answer_id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "answer_option_id")
	private AnswerOption answer_option;

	
	public Long getChoice_answer_id() {
		return choice_answer_id;
	}


	public void setChoice_answer_id(Long choice_answer_id) {
		this.choice_answer_id = choice_answer_id;
	}


	public AnswerOption getAnswer_option() {
		return answer_option;
	}


	public void setAnswer_option(AnswerOption answer_option) {
		this.answer_option = answer_option;
	}

	

	public ChoiceAnswer(AnswerOption answer_option) {
		super();
		this.answer_option = answer_option;
	}


	public ChoiceAnswer() {}
	
	
	
	
}
