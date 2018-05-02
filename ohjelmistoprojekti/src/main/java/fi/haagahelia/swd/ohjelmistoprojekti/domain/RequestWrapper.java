package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import java.util.List;

public class RequestWrapper {
	
	
	
	TextAnswer text_answer;
	AnswerOption answer_option;
	List<TextAnswer> tanswerList;
	List<AnswerOption> optionList;
	
	public List<AnswerOption> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<AnswerOption> optionList) {
		this.optionList = optionList;
	}
	public List<TextAnswer> getTanswerList() {
		return tanswerList;
	}
	public void setTanswerList(List<TextAnswer> tanswerList) {
		this.tanswerList = tanswerList;
	}
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
