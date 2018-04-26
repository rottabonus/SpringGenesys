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

import fi.haagahelia.swd.ohjelmistoprojekti.domain.Answer;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.AnswerRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.Question;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.QuestionRepository;
import fi.haagahelia.swd.ohjelmistoprojekti.domain.Survey;

@CrossOrigin
@Controller
public class RestController {
	
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

		//REST questions by survey
		@CrossOrigin
		@RequestMapping(value="/questions/survey/{id}", method=RequestMethod.GET)
		public @ResponseBody List<Question> findSurveyQuestionRest(@PathVariable("id") Survey survey){
			return (List<Question>) survey.getQuestion_list();
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
		
		//POST answers by Survey
		@RequestMapping(value="/answers/survey/{id}", method=RequestMethod.POST)
		public @ResponseBody List<Answer> createAnswerListBySurvey(@PathVariable("id") Survey survey, @RequestBody List<Answer> answerList){

			List<Question> questionList = findSurveyQuestionRest(survey);
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
