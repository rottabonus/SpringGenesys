package fi.haagahelia.swd.ohjelmistoprojekti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.swd.ohjelmistoprojekti.domain.Answer;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.AnswerRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.Question;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.QuestionRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.Team;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.TeamRepository;

@CrossOrigin
@Controller
public class QController {
	@Autowired
	private QuestionRepository qrepository;
	
	@Autowired
	private TeamRepository trepository;
	

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
	@CrossOrigin
	@RequestMapping(value="/questions/team/{id}", method=RequestMethod.GET)
	public @ResponseBody List<Question> findTeamQuestionRest(@PathVariable("id") Team team){
		return (List<Question>) team.getQuestion_list();
	}
	


	@RequestMapping(value="/teamlist", method=RequestMethod.GET)
	public String teamList(Model model){
		model.addAttribute("teams", trepository.findAll());
		return "teamlist";
	}
	
	@RequestMapping(value="/add")
	public String addTeam(Model model){
		model.addAttribute("team", new Team());
		return "newteam";

	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Team team){
		trepository.save(team);
		return "redirect:/teamlist";
	}
	
	@RequestMapping(value="/questionlist/team/{id}", method=RequestMethod.GET)
	public String questionlist(@PathVariable("id") Long teamId, Model model){
		model.addAttribute("teams", trepository.findOne(teamId));
		model.addAttribute("questions", qrepository.findAll());
		return "questionlist";
	}

	// POST answer by questionId
	@RequestMapping(value="/answers/{id}", method=RequestMethod.POST)
	public @ResponseBody Answer createAnswer(@PathVariable("id") Question questionId, @RequestBody Answer answer){
		answer.setQuestion(questionId);
		 arepository.save(answer);
		return answer;
	}
	
	//GET all answers
	@RequestMapping(value="/answers", method=RequestMethod.GET)
	public @ResponseBody List<Answer> answerListRest() {	
        return (List<Answer>) arepository.findAll();
	}
	
	//POST answers by Team
	@RequestMapping(value="/answers/team/{id}", method=RequestMethod.POST)
	public @ResponseBody List<Answer> createAnswerListByTeam(@PathVariable("id") Team team, @RequestBody List<Answer> answerList){

		List<Question> questionList = findTeamQuestionRest(team);
		Long questionId = questionList.get(0).getQuestion_id();
		
			System.out.println("questionLists first question_id is: "+ questionId + " and questionlist.size() is: " + questionList.size() + 
					" and questionLists first question is: " + questionList.get(0).getQuestion());
			
		//Loop through answers and assign questions 
		int c = 0;
			for(Long i = questionId; i < answerList.size() + questionId; i++) {
				Answer answer = answerList.get(c);
					answer.setQuestion(qrepository.findOne(i));
						c++;
							System.out.println("Question id: " + i + " and question: " + qrepository.findOne(i).getQuestion() + 
									"\nAnswer:  " + answer.getAnswer() + " and answerCounter c: " + c);	
						}
		//Saves answerList answers to database
		arepository.save(answerList);
			System.out.println("answerList.size() is : " + answerList.size() +
					" and answerLists first answer is : " + answerList.get(0).getAnswer());
							return (List<Answer>) answerList;
				}
			}
