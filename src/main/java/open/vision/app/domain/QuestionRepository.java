package open.vision.app.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	
		List<Question> findByTitle(String title);
		List<Question> findByQuestionId(long questionId);
		List<Question> findAllByType(String type);
	//	List<Question> findAnswersByQuestion(List<Answer> answers);
		

}