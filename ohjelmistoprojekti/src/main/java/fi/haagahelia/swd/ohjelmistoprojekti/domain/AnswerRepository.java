package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AnswerRepository extends CrudRepository<TextAnswer, Long>{

	@Query("SELECT text_answer FROM text_answer AS ao "
			+ "JOIN Question AS qu ON a.question_id=qu.question_id JOIN Survey AS su ON su.survey_id=qu.survey_id "
			+ "WHERE su.survey_id= :id")
	ArrayList getTextAnswerListBySurvey(@Param("id") Long id);
}	

