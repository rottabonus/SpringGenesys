package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ChoiceAnswerRepository extends CrudRepository<ChoiceAnswer, Long>{

//	SELECT ca.answer_option_id FROM choice_answer AS ca 
//	JOIN answer_option AS ao ON ca.answer_option_id=ao.answer_option_id
//			JOIN question AS qu ON ao.question_id=qu.question_id
//			JOIN survey AS su ON qu.survey_id=su.survey_id 
//			WHERE su.survey_id=1;
	@Query(value ="SELECT choice_answer.choice_answer_id, choice_answer.answer_option_id, question.question_id FROM choice_answer "
			+ "JOIN answer_option ON choice_answer.answer_option_id=answer_option.answer_option_id "
			+ "JOIN question ON answer_option.question_id=question.question_id "
			+ "JOIN survey ON question.survey_id=survey.survey_id "
			+ "WHERE survey.survey_id= :id", nativeQuery = true)
	public ArrayList<String> getChoiceAnswerListBySurvey(@Param("id") Long id);
	
	@Query(value ="SELECT choice_answer.choice_answer_id, choice_answer.answer_option_id, question.question_id FROM choice_answer "
			+ "JOIN answer_option ON choice_answer.answer_option_id=answer_option.answer_option_id "
			+ "JOIN question ON answer_option.question_id=question.question_id "
			+ "JOIN survey ON question.survey_id=survey.survey_id "
			+ "WHERE survey.survey_id= :id", nativeQuery = true)
	public List<ChoiceAnswer> getChoiceAnswerListBySurveyTest(@Param("id") Long id);
}
