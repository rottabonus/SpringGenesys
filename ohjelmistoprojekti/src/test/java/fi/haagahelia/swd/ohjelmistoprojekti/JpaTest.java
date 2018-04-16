package fi.haagahelia.swd.ohjelmistoprojekti;




import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import fi.haagahelia.swd.ohjelmistoprojekti.domain.Question;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.QuestionRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaTest {

@Autowired
private QuestionRepository repo;
	
@Test
public void finbById() {
	
//Testauksen testi esimerkki
//Testataan, että question taulussa on edes yksi question	
	
	
List <Question> question = (List<Question>) repo.findAll();


assertTrue(question.size() > 0);

}
	
}
