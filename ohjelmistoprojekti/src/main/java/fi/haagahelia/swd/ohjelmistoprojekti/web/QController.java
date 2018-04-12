package fi.haagahelia.swd.ohjelmistoprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.swd.ohjelmistoprojekti.domain.QuestionRepository;


@RestController
public class QController {

	@Autowired
	private QuestionRepository qrepository;
	
	//@RequestMapping("/question")
	//public Question question(@RequestParam(value="jotain") )
	
	
}
