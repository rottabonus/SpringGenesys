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
public class Survey {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long survey_id;
	
	private String survey_name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
	@JsonIgnore
	private List<Question>  question_list;

	public Long getSurvey_id() {
		return survey_id;
	}

	public void setSurvey_id(Long survey_id) {
		this.survey_id = survey_id;
	}

	public String getSurvey_name() {
		return survey_name;
	}

	public void setSurvey_name(String survey_name) {
		this.survey_name = survey_name;
	}

	public List<Question> getQuestion_list() {
		return question_list;
	}

	public void setQuestion_list(List<Question> question_list) {
		this.question_list = question_list;
	}

	public Survey(String survey_name, List<Question> question_list) {
		super();
		this.survey_name = survey_name;
		this.question_list = question_list;
	}

	public Survey() {}
	
	
}
