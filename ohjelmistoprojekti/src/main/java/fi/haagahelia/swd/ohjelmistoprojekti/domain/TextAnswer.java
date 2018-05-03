package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TextAnswer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long text_answer_id;
	
	private String text_answer;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;

	public Long getAnswer_id() {
		return text_answer_id;
	}

	public void setAnswer_id(Long text_answer_id) {
		this.text_answer_id = text_answer_id;
	}

	public String getAnswer() {
		return text_answer;
	}

	public void setAnswer(String text_answer) {
		this.text_answer = text_answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public TextAnswer(String text_answer, Question question) {
		super();
		this.text_answer = text_answer;
		this.question = question;
	}

	public TextAnswer() {}
		
	
	
	
}
