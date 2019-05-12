package open.vision.app.domain;

public class AnswerCreatorObject {

	private String answerValue;
	private Long questionId;
	
	public AnswerCreatorObject() {
		super();
	}

	public AnswerCreatorObject(String answerValue, Long questionId) {
		super();
		this.answerValue = answerValue;
		this.questionId = questionId;
	}

	public String getAnswerValue() {
		return answerValue;
	}

	public void setAnswerValue(String answerValue) {
		this.answerValue = answerValue;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	@Override
	public String toString() {
		return "AnswerCreatorObject [answerValue=" + answerValue + ", questionId=" + questionId + "]";
	}
	
}
