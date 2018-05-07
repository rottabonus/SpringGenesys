package fi.haagahelia.swd.ohjelmistoprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.swd.ohjelmistoprojekti.domain.Question;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.QuestionRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.QuestionTypeRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.Survey;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.SurveyRepository;

@Controller
public class QController {
	
	@Autowired
	private QuestionRepository qrepository;
	
	@Autowired
	private SurveyRepository srepository;
	
	@Autowired
	private QuestionTypeRepository qtrepository;
	

	@RequestMapping(value="/surveylist", method=RequestMethod.GET)
	public String surveyList(Model model){
		model.addAttribute("surveys", srepository.findAll());
		return "surveylist";
	}
	
	@RequestMapping(value="/addsurvey")
	public String addSurvey(Model model){	
		model.addAttribute("survey", new Survey());
		return "newsurvey";
	}


	@RequestMapping(value="/savesurvey", method=RequestMethod.POST)
	public String savesurvey(Survey survey){
		srepository.save(survey);
		return "redirect:/surveylist";
	}
	

	@RequestMapping(value="/editsurvey/{id}")
	public String editTeam(@PathVariable("id") Long surveyId, Model model){
		model.addAttribute("survey", srepository.findOne(surveyId));
		return "editsurvey";
	}
	

	@RequestMapping(value="/questionlist/survey/{id}", method=RequestMethod.GET)
	public String questionlist(@PathVariable("id") Long surveyId, Model model){
		model.addAttribute("surveys", srepository.findOne(surveyId));
		model.addAttribute("questions", qrepository.findAll());
		return "questionlist";
	}
	
	@RequestMapping(value="/newquestion")
	public String newQuestion(Model model){
		model.addAttribute("question", new Question());
		model.addAttribute("surveys", srepository.findAll());
		model.addAttribute("question_types", qtrepository.findAll());		
		return "newquestion";
	}

	@RequestMapping(value="/savequestion", method=RequestMethod.POST)
	public String savequestion(Question question){
		qrepository.save(question);
		return "redirect:/surveylist";
	}
}
