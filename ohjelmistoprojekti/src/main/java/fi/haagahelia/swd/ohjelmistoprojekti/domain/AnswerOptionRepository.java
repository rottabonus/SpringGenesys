package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AnswerOptionRepository extends CrudRepository<AnswerOption, Long>{

	@Query(value ="SELECT * FROM answer_option "
			+ "JOIN question ON question.question_id=answer_option.question_id "
			+ "WHERE question.question_id= :id", nativeQuery = true)
	public List<AnswerOption> getAnswerOptionListBySurvey(@Param("id") Long questionId);
	
}
