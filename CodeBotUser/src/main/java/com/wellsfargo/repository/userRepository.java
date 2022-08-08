package com.wellsfargo.repository;

import org.springframework.data.repository.CrudRepository;

import com.wellsfargo.Entity.UserEntity;

public interface userRepository extends CrudRepository<UserEntity, Long> {
	UserEntity findByusername(String username);

}
