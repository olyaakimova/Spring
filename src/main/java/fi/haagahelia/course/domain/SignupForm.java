//Spring SignupForm 
//form to create users

package fi.haagahelia.course.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class SignupForm {
	
	//username
	@NotEmpty
	@Size(min=4,max=30)
	private String username = "";
	
	//password
	@NotEmpty
	@Size(min=7,max=30)
	private String password = "";
	
	//passwordCheck - enter password again
	@NotEmpty
	@Size(min=7,max=30)
	private String passwordCheck ="";
	
	//set a defaultRole
	private String role = "USER";

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
	
	
	
}
