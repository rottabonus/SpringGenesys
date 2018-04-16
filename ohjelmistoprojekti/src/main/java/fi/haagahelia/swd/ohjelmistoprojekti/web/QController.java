package fi.haagahelia.swd.ohjelmistoprojekti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.swd.ohjelmistoprojekti.domain.Answer;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.AnswerRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.Question;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.QuestionRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.Team;


@RestController
public class QController {
	@Autowired
	private QuestionRepository qrepository;
	@Autowired
	private AnswerRepository arepository;
	
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

	//REST questions by team
	@RequestMapping(value="/questions/team/{id}", method=RequestMethod.GET)
	public @ResponseBody List<Question> findTeamQuestionRest(@PathVariable("id") Team team){
		return (List<Question>) team.getQuestion_list();
	}
	
	
	//REST POST answer by questionId
	@RequestMapping(value="/answer/{id}", method = RequestMethod.POST)
	public @ResponseBody Answer createAnswer(@RequestBody Answer answer, @PathVariable("id") Question questionId) {
		
		System.out.println(answer.getAnswer());
		answer.setQuestion(questionId);
		arepository.save(answer);
		return answer;
	}
	
	// REST POST by Team
	@RequestMapping(value="/answer/team/{id}", method = RequestMethod.POST)
	public @ResponseBody List<Answer> createAnswerList(@PathVariable("id") Team team){
	
		// Get List of questions of team
		List<Question> questionList = findTeamQuestionRest(team);

		// Logging
		System.out.println("tässä on answerlist.indexof(0): " +questionList.indexOf(12) + ", ja tässä on questionList: " + questionList
		+ " ja tässä on listan koko: " + questionList.size() + " testataan lisää: " + questionList.stream().findFirst().get());
		
		
				// go through list of questions
				for (int i = questionList.indexOf(questionList); i < questionList.size(); i++){ 
					
					//magic here
					System.out.println("lul");
					
				}
				
				//change this
		return (List<Answer>) arepository.findAll();

	}
	
	//REST get all answers
	@RequestMapping(value="/answers", method=RequestMethod.GET)
	public @ResponseBody List<Answer> answerListRest() {	
        return (List<Answer>) arepository.findAll();
	}
	
	
}
