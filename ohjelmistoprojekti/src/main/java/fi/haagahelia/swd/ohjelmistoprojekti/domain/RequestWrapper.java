package fi.haagahelia.swd.ohjelmistoprojekti.domain;

public class RequestWrapper {
	
	
	
	TextAnswer text_answer;
	AnswerOption answer_option;
	
	
	
	public AnswerOption getAnswer_option() {
		return answer_option;
	}
	public void setAnswer_option(AnswerOption answer_option) {
		this.answer_option = answer_option;
	}
	
	public TextAnswer getText_answer() {
		return text_answer;
	}
	public void setText_answer(TextAnswer text_answer) {
		this.text_answer = text_answer;
	}
	
	

}
