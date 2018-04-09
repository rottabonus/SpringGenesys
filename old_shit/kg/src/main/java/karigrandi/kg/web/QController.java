package karigrandi.kg.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import karigrandi.kg.domain.Qstn;
import karigrandi.kg.domain.QuestionRepository;

@Controller
public class QController {
	@Autowired
	QuestionRepository qrepositrory;
	
	//REST
	@RequestMapping(value="/")
	public @ResponseBody List<Qstn> getQuestions(){
		return (List<Qstn>) qrepositrory.findAll(); 
		
	}
	
	
}