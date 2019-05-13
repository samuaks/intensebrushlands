package open.vision.app.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SignupForm {
	
	@NotEmpty
	@Size(min=2, max=10)
	private String username="";
	
	@NotEmpty
	@Size(min=5, max=15)
	private String password="";
	
	@NotEmpty
	@Size(min=5, max=15)
	private String passwordTest="";
	
	@NotEmpty
	private String role="USER";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordTest() {
		return passwordTest;
	}

	public void setPasswordTest(String passwordTest) {
		this.passwordTest = passwordTest;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}