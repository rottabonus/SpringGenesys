package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
	
public interface SurveyRepository extends CrudRepository<Survey, Long> {
@Query(value="SELECT * FROM survey WHERE survey_id= :id", nativeQuery = true)
	public List<Survey> getSurveys(@Param("id") Long id);
}
