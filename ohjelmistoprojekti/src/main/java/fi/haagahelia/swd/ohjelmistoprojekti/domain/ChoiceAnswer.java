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
	private Option option;

	public Long getChoice_id() {
		return choice_id;
	}

	public void setChoice_id(Long choice_id) {
		this.choice_id = choice_id;
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public ChoiceAnswer(Option option) {
		super();
		this.option = option;
	}

	public ChoiceAnswer() {}
	
	
	
	
}
