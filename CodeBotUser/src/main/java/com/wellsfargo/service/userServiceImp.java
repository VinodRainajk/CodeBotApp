package com.wellsfargo.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.Entity.UserEntity;
import com.wellsfargo.Entity.UserRoleMapping;
import com.wellsfargo.model.Users;
import com.wellsfargo.model.userRoleModel;
import com.wellsfargo.repository.userRepository;
import com.wellsfargo.repository.userRoleRepository;

@Service
public class userServiceImp implements userService {

	userRepository userrepo;
	userRoleRepository userrolemapping; 

	
	@Autowired
	public userServiceImp(userRepository usrrepo,userRoleRepository userrolemapping)
	{
		this.userrepo = usrrepo;
		this.userrolemapping = userrolemapping;
	}
	
	

	

	@Override
	public Users createuser(Users user) {
		// TODO Auto-generated method stub
		ModelMapper modelmapper = new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userentity = modelmapper.map(user, UserEntity.class);

		userrepo.save(userentity);
		userrolemapping.save(modelmapper.map(user.getUserrolemodel(), UserRoleMapping.class));
		
		return null;
	}



	@Override
	public Users getUser(String UserName) {
		UserEntity userentity = userrepo.findByusername(UserName);
		System.out.println("in model after setting is"+ userentity.getUserRoleMapping().getRole());
		UserRoleMapping rolemapping = userentity.getUserRoleMapping();
		
		ModelMapper modelmapper = new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Users user = modelmapper.map(userentity, Users.class);
		
		
		ModelMapper modelmapper2 = new ModelMapper();
		modelmapper2.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		userRoleModel userolemodel = modelmapper2.map(rolemapping, userRoleModel.class);
		user.setUserrolemodel(userolemodel);
		
		return user;
	}





	@Override
	public Users updateuser(Users user) {
		    UserEntity userentity = userrepo.findByusername(user.getUsername());
		    // crush the variables of the object found
		    userentity.setEmail(user.getEmail());
		    userentity.getUserRoleMapping().setRole(user.getUserrolemodel().getRole());
		    userrepo.save(userentity);

		return null;
	}
}
