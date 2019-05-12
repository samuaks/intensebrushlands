package open.vision.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class AnswerOption {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long answerOptionId;
	private String value;
	
	@ManyToOne
	@JoinColumn(name = "questionId")
	private Question question;

	public AnswerOption() {}

	public AnswerOption(String value, Question question) {
		super();
		this.value = value;
		this.question = question;
	}
	
	public Long getAnswerOptionId() {
		return answerOptionId;
	}

	public void setAnswerOptionId(Long answerOptionId) {
		this.answerOptionId = answerOptionId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Question getQuestions() {
		return question;
	}

	public void setQuestions(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "AnswerOption [answerOptionId=" + answerOptionId + ", value=" + value + ", question=" + question + "]";
	}

}
