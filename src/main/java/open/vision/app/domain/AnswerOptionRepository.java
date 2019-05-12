package open.vision.app.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AnswerOptionRepository extends CrudRepository<AnswerOption, Long> {
	
		List<AnswerOption> findByValue(String value);
}