package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ChoiceAnswerRepository extends CrudRepository<ChoiceAnswer, Long>{

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
