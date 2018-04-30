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
public class ChoiceAnswer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long choice_answer_id;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "answer_option_id")
	@JsonIgnore
	public List<AnswerOption>  answer_option;

	public Long getChoice_id() {
		return choice_answer_id;
	}

	public Long getChoice_answer_id() {
		return choice_answer_id;
	}



	public void setChoice_answer_id(Long choice_answer_id) {
		this.choice_answer_id = choice_answer_id;
	}



	public List<AnswerOption> getAnswer_option() {
		return answer_option;
	}



	public void setAnswer_option(List<AnswerOption> answer_option) {
		this.answer_option = answer_option;
	}



	public ChoiceAnswer() {}
	
	
	
	
}
