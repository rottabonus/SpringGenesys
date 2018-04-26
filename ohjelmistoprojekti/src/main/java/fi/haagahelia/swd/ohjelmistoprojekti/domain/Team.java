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
public class Team {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long team_id;
	
	private String team_name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
	@JsonIgnore
	public List<Question>  question_list;

	public Long getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Long team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public List<Question> getQuestion_list() {
		return question_list;
	}

	public void setQuestion_list(List<Question> question_list) {
		this.question_list = question_list;
	}

	public Team(String team_name, List<Question> question_list) {
		super();
		this.team_name = team_name;
		this.question_list = question_list;
	}

	public Team() {}
	
	
}
