package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long answer_id;
	
	private String answer;
	
	@ManyToOne
	@JoinColumn(name = "question_id", nullable = false)
	private Question question;
	
}
