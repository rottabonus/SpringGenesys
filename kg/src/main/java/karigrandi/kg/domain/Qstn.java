package karigrandi.kg.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Qstn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String question;
	
	public Qstn(){
		super();
		this.question = null;
	}
	
	public Qstn(String question){
		super();
		this.question = question;
	}
	
	public Qstn(Long id, String question) {
		super();
		this.id = id;
		this.question = question;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Qstn [id=" + id + ", question=" + question + "]";
	}
	
	
}

