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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fi.haagahelia.swd.ohjelmistoprojekti.domain.AnswerOption;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.ChoiceAnswer;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.ChoiceAnswerRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.Question;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.QuestionRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.QuestionType;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.RequestWrapper;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.Survey;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.SurveyRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.TextAnswer;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.TextAnswerRepository;

@CrossOrigin
@Controller
public class RestController {
	
	private static final String String = null;

	@Autowired
	private QuestionRepository qrepository;
	
	@Autowired
	private TextAnswerRepository tarepository;
	
	@Autowired
	private ChoiceAnswerRepository carepository;
	@Autowired
	private SurveyRepository srepository;


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
				 tarepository.save(tanswer);
				return "posted textAnswer: " + tanswer.getAnswer();
			}
			
		}
		
		@RequestMapping(value="/answers/bysurvey/{id}", method=RequestMethod.GET)
		public @ResponseBody String getAnswerListBySurvey(@PathVariable("id")Long id){	
			//using Gson-library to parse javalist to JSON
			Gson gsonBuilder = new Gson();
			
			// create list where put all answers from option and text answer tables
			List allAnswers = new ArrayList<>();
			
			// get all text answers
			List tAnswer = new ArrayList<>();
			tAnswer = (List) tarepository.getTextAnswerListBySurvey(id);
			
			// get all choice answers
			List cAnswer = new ArrayList<>();
			cAnswer = carepository.getChoiceAnswerListBySurvey(id);
			
			//add choice and text answer to same list
			 allAnswers.addAll(tAnswer);
			 allAnswers.addAll(cAnswer);
			 
			 //Put allAnswers-list into JSON
			 String jsonFromJavaArrayList = gsonBuilder.toJson(allAnswers);
			 
			return jsonFromJavaArrayList;
				}
		
		//TESTIÄ https://springframework.guru/google-gson-for-json-processing/
		//This method works and goes into JSON
		@RequestMapping(value="/surveystest/{id}", method=RequestMethod.GET)
		public @ResponseBody List<Survey> getsurveystest(@PathVariable("id")Long id){
		
			return srepository.getSurveys(id);
		}
		
		@RequestMapping(value="/answers/bysurveytest/{id}", method=RequestMethod.GET)
		public @ResponseBody String getAnswerListBySurveytest(@PathVariable("id")Long id){	
			Gson gsonBuilder = new Gson();
			String jsonFromJavaArrayList = gsonBuilder.toJson(tarepository.getTextAnswerListBySurvey(id));
//			// create list where put all answers from option and text answer tables
//			List<TextAnswerRepository> allAnswers = new ArrayList<>();
//			
//			// get all text answers
//			List tAnswer = new ArrayList<>();
//			tAnswer = (ArrayList) tarepository.getTextAnswerListBySurvey(id);
			
//			// get all choice answers
//			List cAnswer = new ArrayList<>();
//			cAnswer = carepository.getChoiceAnswerListBySurvey(id);
//			
//			//add choice and text answer to same list//			 allAnswers.addAll(tAnswer);
//			 allAnswers.addAll(cAnswer);

			return jsonFromJavaArrayList;
				}
		}




