package fi.haagahelia.swd.ohjelmistoprojekti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.swd.ohjelmistoprojekti.domain.Question;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.QuestionRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.Team;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.TeamRepository;


@Controller
public class QController {
	@Autowired
	private QuestionRepository qrepository;
	
	@Autowired
	private TeamRepository trepository;
	
	
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

	
}
