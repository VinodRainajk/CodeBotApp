package com.wellsfargo.repository;

import org.springframework.data.repository.CrudRepository;

import com.wellsfargo.Entity.UserRoleMapping;

public interface userRoleRepository extends CrudRepository<UserRoleMapping, String> {

}
