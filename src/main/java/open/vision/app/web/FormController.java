package open.vision.app.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import open.vision.app.domain.Answer;
import open.vision.app.domain.AnswerCreatorObject;
import open.vision.app.domain.AnswerOption;
import open.vision.app.domain.AnswerOptionCreator;
import open.vision.app.domain.AnswerOptionRepository;
import open.vision.app.domain.Question;
import open.vision.app.domain.QuestionRepository;


@Controller
public class FormController {

	@Autowired
	private QuestionRepository qRepo;
	
	@Autowired 
	private AnswerOptionRepository aRepo;
	

	
	//RESTful service to get all questions
	@CrossOrigin(origins = "https://localhost:8080")
	@RequestMapping(value="/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question> getQuestionRest(){
		return (List<Question>) qRepo.findAll();
	}
	
	//RESTful service to get one questions
	@RequestMapping(value="/question/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Question> findQuestionRest(@PathVariable("id") Long id) {
		return qRepo.findById(id);
	}
	
	// == RESTful service to get one question by type ==
	@RequestMapping(value="/questionType/{type}", method=RequestMethod.GET)
	public @ResponseBody List<Question> questions (@PathVariable("type") String type) {					
		return qRepo.findAllByType(type);
	}
	
	//RESTful service to get all answer options
	@RequestMapping(value="/answerOptions", method = RequestMethod.GET)
	public @ResponseBody List<AnswerOption> getAnswerRest(){
		return (List<AnswerOption>) aRepo.findAll();
	}
	
	//RESTful service to get one answer options by id
	@RequestMapping(value="/answerOption/{answerid}", method=RequestMethod.GET)
	public @ResponseBody Optional<AnswerOption> findAnswerRest(@PathVariable("answerid") Long id) {
		return aRepo.findById(id);
	}
	
	//RESTful service to create question
	@RequestMapping(value="/createQuestion", method=RequestMethod.GET)
	public String createQuestion(Model model) {
		model.addAttribute("question", new Question());
	    model.addAttribute("option", new AnswerOption());
		return "createq";
	}
	
	//Save method for new question
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveQuestion(@ModelAttribute Question question) {
		qRepo.save(question);
		return "redirect:/qlist";
		
	}
	
	//List of questions
	@RequestMapping(value="/qlist")
	public String getQuestions(Model model) {
		List<Question> questions = (List<Question>) qRepo.findAll();
		model.addAttribute("questions", questions);
		return "qlistform";
	}
	
	//Add answerOptions to newly selected
	@RequestMapping(value="edit/{id}")
	public String editQuestion(@PathVariable("id") Long id, Model model) {
		model.addAttribute("question", qRepo.findById(id));
		return "editq";
	}
	
	//Save method for answerOptions 
	@RequestMapping(value="/saveo", method=RequestMethod.POST)
	public String saveOptions(AnswerOptionCreator answerOptionCreator) {
		String value = answerOptionCreator.getValue();
		Long questionId = answerOptionCreator.getQuestionId();
		
		Question question = qRepo.findByQuestionId(questionId).get(0);
		AnswerOption answerOption = new AnswerOption(value, question);
		aRepo.save(answerOption);
		return "redirect:/qlist";
	}
	
	//Delete question
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String deleteQuestion(@PathVariable("id") Long id) {
		qRepo.deleteById(id);
		return "redirect:../qlist";
	}
	
	//Add answerOptions
	@RequestMapping(value="/add/{id}", method=RequestMethod.GET)
	public String addOptions(@PathVariable("id") Long questionId, Model model) {
		model.addAttribute("answerOptionCreator", new AnswerOptionCreator(questionId));
		return "createoptions";
	}
	
	//
	
	
	
	
}
