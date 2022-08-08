package com.wellsfargo.model;

public class Users {

 public	String  username;
 public	String  email;
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
	

private userRoleModel userrolemodel;

public userRoleModel getUserrolemodel() {
	return userrolemodel;
}
public void setUserrolemodel(userRoleModel userrolemodel) {
	this.userrolemodel = userrolemodel;
}

}
