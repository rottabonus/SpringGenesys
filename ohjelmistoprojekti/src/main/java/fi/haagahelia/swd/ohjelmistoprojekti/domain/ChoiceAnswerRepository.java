package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ChoiceAnswerRepository extends CrudRepository<ChoiceAnswer, Long>{
// tässä koodissa on vielä jotain virhettä
//	uusittua koodia
//	SELECT choice_answer_id FROM choice_answer AS ca JOIN answer_option AS op ON ca.choice_answer_id=op.choice_answer_id JOIN question AS qu ON op.question_id=qu.question_id JOIN survey AS su ON
//			qu.survey_id=su.survey_id WHERE su.survey_id=1;
	@Query("SELECT option_id "
			+ "FROM choice_answer AS ca JOIN option AS op ON ca.choice_answer_id=op.choice_answer_id "
			+ "JOIN question AS qu ON op.question_id=qu.question_id JOIN survey AS su "
			+ "ON qu.survey_id=su.survey_id"
			+ "WHERE su.survey_id= :id")
	ArrayList getChoiceAnswerListBySurvey(@Param("id") Long id);
}
