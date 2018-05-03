package fi.haagahelia.swd.ohjelmistoprojekti.web;

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
		
		//REST AnswerOptions by questionId
		@RequestMapping(value="/answeroptions/question/{id}", method=RequestMethod.GET)
		public @ResponseBody List<AnswerOption> findAnswerOptionsByQuestionRest(@PathVariable("id") Question questionId){
			return (List<AnswerOption>) questionId.getOption_list();
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
		
		//GET all answers
//		@RequestMapping(value="/answers", method=RequestMethod.GET)
//		public @ResponseBody List<TextAnswer> answerListRest() {	
//	        return (List<TextAnswer>) arepository.findAll();
//		}
		
		//POST answers by Survey
		@RequestMapping(value="/answers/survey/{id}", method=RequestMethod.POST)
		public @ResponseBody List<TextAnswer> createAnswerListBySurvey(@PathVariable("id") Survey survey, @RequestBody RequestWrapper requestWrapper){

			List<Question> questionList = findSurveyQuestionRest(survey);
			Long questionId = questionList.get(0).getQuestion_id();
			
			List<TextAnswer> answerList = requestWrapper.getTanswerList();
			List<AnswerOption> optionList = requestWrapper.getOptionList();
			
				System.out.println("questionLists first question_id is: "+ questionId + " and questionlist.size() is: " + questionList.size() + 
						" and questionLists first question is: " + questionList.get(0).getQuestion() +
						"\n and answerList size is: " + answerList.size() + "\nand answerList first answer is " + answerList.get(0).getAnswer() +
						"\n and optionList size is " +optionList.size() + "\nand optionList first option is" + optionList.get(0).getAnswer_option());
				
			//Loop through answers and assign questions 
//			int c = 0;
//				for(Long i = questionId; i < answerList.size() + questionId; i++) {
//					
//					//checkQuestionType
//					Question question = qrepository.findOne(questionId);
//					question.getQuestion_type();
//					QuestionType questionType = new QuestionType();
//					Long type = questionType.getQuestion_type_id();
//					if(type == 1){
//						System.out.println(type);
//					}
//				}
//					TextAnswer answer = answerList.get(c);
//						answer.setQuestion(qrepository.findOne(i));
//							c++;
//								System.out.println("Question id: " + i + " and question: " + qrepository.findOne(i).getQuestion() + 
//										"\nAnswer:  " + answer.getAnswer() + " and answerCounter c: " + c);	
//							}
//			//Saves answerList answers to database
//			arepository.save(answerList);
//				System.out.println("answerList.size() is : " + answerList.size() +
//						" and answerLists first answer is : " + answerList.get(0).getAnswer());
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




