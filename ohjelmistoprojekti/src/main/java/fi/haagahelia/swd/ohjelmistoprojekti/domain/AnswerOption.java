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
public class AnswerOption {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long answer_option_id;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	private String answer_option;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "answer_option")
	@JsonIgnore
	private List<ChoiceAnswer> choice_answer_list;
	
	
	public Long getAnswer_option_id() {
		return answer_option_id;
	}

	public void setAnswer_option_id(Long answer_option_id) {
		this.answer_option_id = answer_option_id;
	}

	

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	
	public String getAnswer_option() {
		return answer_option;
	}

	public void setAnswer_option(String answer_option) {
		this.answer_option = answer_option;
	}


	public List<ChoiceAnswer> getChoice_answer_list() {
		return choice_answer_list;
	}

	public void setChoice_answer_list(List<ChoiceAnswer> choice_answer_list) {
		this.choice_answer_list = choice_answer_list;
	}

	public AnswerOption(Question question, String answer_option, List<ChoiceAnswer> choice_answer_list) {
		super();
		this.question = question;
		this.answer_option = answer_option;
		this.choice_answer_list = choice_answer_list;
	}

	public AnswerOption() {}

	
}
