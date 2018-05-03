package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TextAnswerRepository extends CrudRepository<TextAnswer, Long> {

	@Query(value="SELECT text_answer, qu.question_id FROM text_answer AS ta "
			+ "JOIN question AS qu ON ta.question_id=qu.question_id JOIN survey AS su ON su.survey_id=qu.survey_id "
			+ "WHERE su.survey_id= :id", nativeQuery = true)
	public List getTextAnswerListBySurvey(@Param("id") Long id);
}
