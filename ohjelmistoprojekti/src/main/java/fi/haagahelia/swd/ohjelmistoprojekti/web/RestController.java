package fi.haagahelia.swd.ohjelmistoprojekti.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.swd.ohjelmistoprojekti.domain.AnswerOption;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.AnswerOptionRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.AnswerRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.ChoiceAnswer;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.ChoiceAnswerRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.Question;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.QuestionRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.QuestionType;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.RequestWrapper;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.Survey;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.TextAnswer;

@CrossOrigin
@Controller
public class RestController {
	
	@Autowired
	private QuestionRepository qrepository;
	
	@Autowired
	private AnswerRepository arepository;
	
	@Autowired
	private ChoiceAnswerRepository carepository;
	
	@Autowired
	private AnswerOptionRepository aorepository;
	


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

		//REST questions by survey
		@RequestMapping(value="/questions/survey/{id}", method=RequestMethod.GET)
		public @ResponseBody List<Question> findSurveyQuestionRest(@PathVariable("id") Survey survey){
			return (List<Question>) survey.getQuestion_list();
		}
		
										
		//POST any answer by questionId
		@RequestMapping(value="/answers/question/{id}", method=RequestMethod.POST)
		public @ResponseBody String createAnswer(@PathVariable("id") Question questionId, @RequestBody RequestWrapper requestWrapper){
			
			//checkQuestionType
			QuestionType questionType = questionId.getQuestion_type();
			Long type = questionType.getQuestion_type_id();
			System.out.println(type + "\nRequestWrapper: " + requestWrapper.getAnswer_option());
			String error = "Something went wrong";
			
			if(type == 1){
				
				if(requestWrapper.getAnswer_option() != null){
					//Create new ChoiceAnswer and set Option
					ChoiceAnswer answer = new ChoiceAnswer();
					AnswerOption option = requestWrapper.getAnswer_option();
					answer.setAnswer_option(option);
					System.out.println(answer.getChoice_answer_id());			
					//save choiceAnswer
					carepository.save(answer);
					System.out.println(answer.getChoice_answer_id());
					return "posted choiceAnswer: " + answer.getChoice_answer_id();
				}
				return error;
			}
			
			else {
				
				if(requestWrapper.getText_answer() != null){
					TextAnswer tanswer = requestWrapper.getText_answer();
					System.out.println("inside textanswer loop " + tanswer.getAnswer()+
					"\nquestionId: "  + questionId.getQuestion_id());
					tanswer.setQuestion(questionId);
					 arepository.save(tanswer);
					return "posted textAnswer: " + tanswer.getAnswer();
				}
				return error;
			}
			
		}
		
		//GET all answers
		@RequestMapping(value="/answers", method=RequestMethod.GET)
		public @ResponseBody List<Object> answerListRest() {
			
			
			Iterable<TextAnswer> textAnswers = arepository.findAll();
			Iterable<AnswerOption> answerOptions = aorepository.findAll();
			
			List<Object> mergedList = new ArrayList<>();
			
			textAnswers.forEach(mergedList::add);
			answerOptions.forEach(mergedList::add);
			
			
			
	        return mergedList;
		}
		

		
		
		/*//REST questions by survey
				@CrossOrigin
				@RequestMapping(value="/questions/survey/{id}", method=RequestMethod.GET)
				public @ResponseBody List<Question> findSurveyQuestionRest(@PathVariable("id") Survey survey){
					return (List<Question>) survey.getQuestion_list();
				}*/
		
		//GET answers by Survey THIS IS NOT FINISHED!!!!!
//		@RequestMapping(value="/answers/bysurvey/{id}", method=RequestMethod.GET)
//		public @ResponseBody List<TextAnswer> getAnswerListBySurvey(@PathVariable("id")Survey survey){
//			return (List<TextAnswer>) arepository.findAll();
//				}
		}




