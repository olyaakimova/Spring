//Spring Permission
package fi.haagahelia.course.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Permission {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long permissionId;
	private User permittedUser;
	private String role;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "noteId")
	private Note note;
	
	
	public Permission(User permittedUser, String role) {
		super();
		this.permittedUser = permittedUser;
		this.role = role;
	}
	
	public Permission(){}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public User getPermittedUser() {
		return permittedUser;
	}

	public void setPermittedUser(User permittedUser) {
		this.permittedUser = permittedUser;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	//public boolean evaluatePermission(){
	//	return true;
	//}

	@Override
	public String toString() {
		return "Permission [permissionId=" + permissionId + ", permittedUser=" + permittedUser + ", role=" + role + "]";
	}
	
	
	
	
	
}
