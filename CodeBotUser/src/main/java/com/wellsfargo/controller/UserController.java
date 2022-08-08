package com.wellsfargo.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.model.Users;
import com.wellsfargo.service.userService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	userService UserService;

	@GetMapping
	 public Users getuser(@RequestBody Users userDetails )
	 {
		ModelMapper modelmapper = new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);		
		Users userdto = modelmapper.map(userDetails, Users.class) ;
		 return  UserService.getUser(userdto.getUsername());
	 }

	@PostMapping
	public String createUser(@RequestBody Users userDetails)
	{
		ModelMapper modelmapper = new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);	

		System.out.println("role name is"+ userDetails.getUserrolemodel().getRole());
		Users userdto = modelmapper.map(userDetails, Users.class) ;
		userdto.setUserrolemodel(userDetails.getUserrolemodel());
		System.out.println("role model after setting is"+ userdto.getUserrolemodel().getRole());
		UserService.createuser(userdto);
		return "User are Created with name " +userDetails.username;
	}

	
	@PutMapping
	public String updateuser(@RequestBody Users userDetails)
	{
		ModelMapper modelmapper = new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);	

		System.out.println("role name is"+ userDetails.getUserrolemodel().getRole());
		Users userdto = modelmapper.map(userDetails, Users.class) ;
		userdto.setUserrolemodel(userDetails.getUserrolemodel());
		System.out.println("role model after setting is"+ userdto.getUserrolemodel().getRole());
		UserService.updateuser(userdto);
		return "User are up[date with name " +userDetails.username;
	}
	
}
