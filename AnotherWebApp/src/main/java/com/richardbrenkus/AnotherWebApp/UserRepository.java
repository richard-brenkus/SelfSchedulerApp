package com.richardbrenkus.AnotherWebApp;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User getUserByUsername(@Param("username") String username);
	
	@Modifying
	@Transactional
	@Query("update User u set u.id = :id where u.username = :username")
	public void updateUserSetIdForUsername(@Param("id") Long id, @Param("username") String username);

	/*
	@Modifying
	@Transactional
	@Query("update User u insert into users_roles values u.id = :id where u.username = :username")
	public void updateUsersRolesTable(@Param("id") Long userId, @Param("roleId") String roleId);
	
//	@Modifying
//	@Query("update User u set u.name = ?, u.username = ?, u.email = ?, u.password = ?, u.gender = ?, u.note = ?, u.married = ?, u.creationDate," 
//			 + "u.birthday = ?, u.profession = ?, u.enabled = ? where u.id = id")
//	public void updateById(@Param("id") Long id);
 * */
 
}
