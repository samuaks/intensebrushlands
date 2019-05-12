package open.vision.app.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

	Optional<Answer> findByAnswerId(Long answerId);

	
}
