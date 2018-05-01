package fi.haagahelia.swd.ohjelmistoprojekti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		public @ResponseBody ResponseEntity<Question> findQuestionRest(@PathVariable("id") Long questionId){
			Question question = qrepository.findOne(questionId);
			QuestionType questiontype = question.getQuestion_type();
			System.out.println(questiontype.getQuestion_type());
			return new ResponseEntity<Question>(question, HttpStatus.OK);
		}

		//REST questions by survey
		@RequestMapping(value="/questions/survey/{id}", method=RequestMethod.GET)
		public @ResponseBody List<Question> findSurveyQuestionRest(@PathVariable("id") Survey survey){
			return (List<Question>) survey.getQuestion_list();
		}
		
		
								
		// POST answer by questionId
		@RequestMapping(value="/answers/question/{id}", method=RequestMethod.POST)
		public @ResponseBody TextAnswer createAnswer(@PathVariable("id") Question questionId, @RequestBody TextAnswer answer){
			answer.setQuestion(questionId);
			System.out.println(answer.getAnswer());
			 arepository.save(answer);
			return answer;
		}
		
		//POST choice_answer by questionId
		@RequestMapping(value="/chanswers/question/{id}", method=RequestMethod.POST)
		public @ResponseBody AnswerOption createChoiceAnswer(@PathVariable("id") Question questionId, @RequestBody AnswerOption option){
			
			//Create new ChoiceAnswer and set Option
			ChoiceAnswer answer = new ChoiceAnswer();
			answer.setAnswer_option(option);
			
			//set AnswerOption for responseBody (not really necessary)
			Long answerOption = option.getAnswer_option_id();
			option.setAnswer_option(aorepository.findOne(answerOption).getAnswer_option());
			
			//save choiceAnswer
			carepository.save(answer);
			return option;
		}
		
		//GET all answers
		@RequestMapping(value="/answers", method=RequestMethod.GET)
		public @ResponseBody List<TextAnswer> answerListRest() {	
	        return (List<TextAnswer>) arepository.findAll();
		}
		
		//POST answers by Survey
		@RequestMapping(value="/answers/survey/{id}", method=RequestMethod.POST)
		public @ResponseBody List<TextAnswer> createAnswerListBySurvey(@PathVariable("id") Survey survey, @RequestBody List<TextAnswer> answerList){

			List<Question> questionList = findSurveyQuestionRest(survey);
			Long questionId = questionList.get(0).getQuestion_id();
			
				System.out.println("questionLists first question_id is: "+ questionId + " and questionlist.size() is: " + questionList.size() + 
						" and questionLists first question is: " + questionList.get(0).getQuestion());
				
			//Loop through answers and assign questions 
			int c = 0;
				for(Long i = questionId; i < answerList.size() + questionId; i++) {
					TextAnswer answer = answerList.get(c);
						answer.setQuestion(qrepository.findOne(i));
							c++;
								System.out.println("Question id: " + i + " and question: " + qrepository.findOne(i).getQuestion() + 
										"\nAnswer:  " + answer.getAnswer() + " and answerCounter c: " + c);	
							}
			//Saves answerList answers to database
			arepository.save(answerList);
				System.out.println("answerList.size() is : " + answerList.size() +
						" and answerLists first answer is : " + answerList.get(0).getAnswer());
								return (List<TextAnswer>) answerList;
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




