package open.vision.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "passwordCheck", nullable = false)
	private String passwordCheck;

	@Column(name = "role", nullable = false)

	private String role;
	
	
	

	public User() {
		super();
	}

	public User(String username, String passwordCheck, String role) {
		super();
		this.username = username;
		this.passwordCheck = passwordCheck;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwordCheck=" + passwordCheck + ", role=" + role
				+ "]";
	}

	
}
