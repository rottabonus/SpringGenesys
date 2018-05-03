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
		public @ResponseBody String createChoiceAnswer(@PathVariable("id") Question questionId, @RequestBody RequestWrapper requestWrapper){
			
			//checkQuestionType
			QuestionType questionType = questionId.getQuestion_type();
			Long type = questionType.getQuestion_type_id();
			System.out.println(type);
			System.out.println(requestWrapper.getAnswer_option() + "  , " + requestWrapper.getText_answer());
			if(type == 1){
				
				//Create new ChoiceAnswer and set Option
				ChoiceAnswer answer = new ChoiceAnswer();
				AnswerOption option = requestWrapper.getAnswer_option();
				answer.setAnswer_option(option);
									
				//save choiceAnswer
				carepository.save(answer);
				return "posted choiceAnswer: " + answer.getChoice_answer_id();
			}
			
			else {
				TextAnswer tanswer = requestWrapper.getText_answer();
				System.out.println("inside textanswer loop " + tanswer.getAnswer()+
				"\nquestionId: "  + questionId.getQuestion_id());
				tanswer.setQuestion(questionId);
				 arepository.save(tanswer);
				return "posted textAnswer: " + tanswer.getAnswer();
			}
			
		}
		@RequestMapping(value="/answers/bysurvey/{id}", method=RequestMethod.GET)
		public @ResponseBody List<TextAnswer> getAnswerListBySurvey(@PathVariable("id")Long id){	
		
			// create list where put all answers from option and text answer tables
			List<TextAnswer> allAnswers = new ArrayList<>();
			
			// get all text answers
			ArrayList tAnswer = new ArrayList<>();
			tAnswer = arepository.getTextAnswerListBySurvey(id);
			
			// get all choice answers
			ArrayList cAnswer = new ArrayList<>();
			cAnswer = carepository.getChoiceAnswerListBySurvey(id);
			
			//add choice and text answer to same list
			 allAnswers.addAll(tAnswer);
			 allAnswers.addAll(cAnswer);
			
			return (List<TextAnswer>) allAnswers;
				}

		}




