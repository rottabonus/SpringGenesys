package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends CrudRepository<Question, Long>{

	@Query(value ="SELECT * FROM question "
			+ "WHERE survey_id= :id", nativeQuery = true)
	public List<Question> getQuestionListBySurvey(@Param("id") Long id);
	
}
