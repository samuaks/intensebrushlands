package open.vision.app.domain;

public class QuestionCreatorObject {

	private String questionValue;
	private String type;
	
	public QuestionCreatorObject() {
		super();
	}

	public QuestionCreatorObject(String questionValue, String type) {
		super();
		this.questionValue = questionValue;
		this.type = type;
	}

	public String getQuestionValue() {
		return questionValue;
	}

	public void setQuestionValue(String questionValue) {
		this.questionValue = questionValue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "QuestionCreatorObject [questionValue=" + questionValue + ", type=" + type + "]";
	}
	
	
	
}
