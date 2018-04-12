package fi.haagahelia.swd.ohjelmistoprojekti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.swd.ohjelmistoprojekti.domain.Question;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.QuestionRepository;


@RestController
public class QController {
	@Autowired
	private QuestionRepository qrepository;
	
	// REST get all questions
	@RequestMapping(value="/questions", method=RequestMethod.GET)
	public @ResponseBody List<Question> questionListRest() {	
        return (List<Question>) qrepository.findAll();
	}
	
	//REST questions by id
	@RequestMapping(value="/questions/{id}", method=RequestMethod.GET)
	public @ResponseBody Question findQuestionRest(@PathVariable("id") Long questionId){
		return qrepository.findOne(questionId);
	}

	
	//@RequestMapping("/question")
	//public Question question(@RequestParam(value="jotain") )
	
	
}
