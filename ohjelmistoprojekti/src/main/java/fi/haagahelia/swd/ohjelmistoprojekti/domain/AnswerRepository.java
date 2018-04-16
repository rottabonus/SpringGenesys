package fi.haagahelia.swd.ohjelmistoprojekti.domain;

import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long>{
	
//	Answer findByAnswerId(Long answer_id);

}
