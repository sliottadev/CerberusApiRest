package com.cerberus.repositories;

import com.cerberus.models.UserTest;

public interface IUserRepoDemo {
	
	public Iterable<UserTest> getUsers();
	
	public UserTest addUser (UserTest usr);
	
	public UserTest getById(Long id);
	
	public UserTest deleteUser(Long Id);
	
	public UserTest modifyUser(Long id, UserTest usr);
	
	public Boolean userExists (Long id);
}
