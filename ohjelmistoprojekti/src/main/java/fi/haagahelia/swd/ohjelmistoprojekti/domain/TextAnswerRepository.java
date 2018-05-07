package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TextAnswerRepository extends CrudRepository<TextAnswer, Long> {

	@Query(value="SELECT text_answer.text_answer_id, text_answer.text_answer, text_answer.question_id FROM text_answer "
			+ "JOIN question ON text_answer.question_id=question.question_id JOIN survey ON question.survey_id=survey.survey_id "
			+ "WHERE survey.survey_id= :id", nativeQuery = true)
	public List<String> getTextAnswerListBySurvey(@Param("id") Long id);
	
	@Query(value="SELECT text_answer.text_answer_id, text_answer.text_answer, text_answer.question_id FROM text_answer "
			+ "JOIN question ON text_answer.question_id=question.question_id JOIN survey ON question.survey_id=survey.survey_id "
			+ "WHERE survey.survey_id= :id", nativeQuery = true)
	public List<TextAnswer> getTextAnswerListBySurveyTest(@Param("id") Long id);
}
