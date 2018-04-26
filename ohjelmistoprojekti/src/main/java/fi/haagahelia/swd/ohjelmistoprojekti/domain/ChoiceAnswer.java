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
	private Long choice_id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="option_id")
	private AnswerOption option;

	public Long getChoice_id() {
		return choice_id;
	}

	public void setChoice_id(Long choice_id) {
		this.choice_id = choice_id;
	}

	public AnswerOption getOption() {
		return option;
	}

	public void setOption(AnswerOption option) {
		this.option = option;
	}

	public ChoiceAnswer(AnswerOption option) {
		super();
		this.option = option;
	}

	public ChoiceAnswer() {}
	
	
	
	
}
