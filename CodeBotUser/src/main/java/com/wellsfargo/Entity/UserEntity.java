package com.wellsfargo.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="userDetails")
@Entity(name="userDetails")
public class UserEntity implements Serializable{
	
	 /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "username")
	public	String  username;
	
	@Column(name = "email")
	 public	String  email;
	
	@Column(name = "password")
	 public	String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "usernamerole")
	private UserRoleMapping userRoleMapping;


	public UserRoleMapping getUserRoleMapping() {
		return userRoleMapping;
	}
	
	public void setUserRoleMapping(UserRoleMapping userRoleMapping) {
		this.userRoleMapping = userRoleMapping;
	}
	
}
