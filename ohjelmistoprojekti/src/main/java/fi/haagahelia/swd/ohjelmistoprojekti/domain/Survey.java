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
	
	private String survey;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
	@JsonIgnore
	public List<Question>  question_list;

	public Long getSurvey_id() {
		return survey_id;
	}

	public void setSurvey_id(Long survey_id) {
		this.survey_id = survey_id;
	}

	public String getSurvey() {
		return survey;
	}

	public void setSurvey(String survey) {
		this.survey = survey;
	}

	public List<Question> getQuestion_list() {
		return question_list;
	}

	public void setQuestion_list(List<Question> question_list) {
		this.question_list = question_list;
	}

	public Survey(String survey, List<Question> question_list) {
		super();
		this.survey = survey;
		this.question_list = question_list;
	}

	public Survey() {}
	
	
}
