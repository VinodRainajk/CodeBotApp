package com.wellsfargo.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name= "UserRoleMapping")
@Entity(name="UserRoleMapping")
public class UserRoleMapping implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "usernamerole")
	private	String  usernamerole;
	

	public String getUsernamerole() {
		return usernamerole;
	}


	public void setUsernamerole(String usernamerole) {
		this.usernamerole = usernamerole;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Column(name = "role")
	private String  role;
	
	@OneToOne(mappedBy = "userRoleMapping")
	public UserEntity userentity;
}
