package com.wellsfargo.service;

import com.wellsfargo.model.Users;

public interface userService {
	public Users createuser (Users user);
	public Users getUser(String UserName);
	public Users updateuser (Users user);
}
