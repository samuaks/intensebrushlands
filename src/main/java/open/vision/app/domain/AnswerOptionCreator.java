package open.vision.app.domain;

public class AnswerOptionCreator {

	private String value;
	private Long questionId;
	
	public AnswerOptionCreator() {
		super();
	}

	public AnswerOptionCreator(Long questionId) {
		super();
		this.questionId = questionId;
	}

	public AnswerOptionCreator(String value, Long questionId) {
		super();
		this.value = value;
		this.questionId = questionId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	@Override
	public String toString() {
		return "AnswerOptionCreator [value=" + value + ", questionId=" + questionId + "]";
	}
	
	
}
