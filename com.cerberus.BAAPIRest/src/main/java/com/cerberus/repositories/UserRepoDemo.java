
package com.cerberus.repositories;

import java.util.ArrayList;
import java.util.List;

import com.cerberus.models.UserTest;

public class UserRepoDemo implements IUserRepoDemo {
	
	
	private List<UserTest> listUser = new ArrayList<UserTest>();
	
	private int getIndexById(Long id) {
		for (UserTest u:listUser) {
			if (u.getId()==id) {
				return listUser.indexOf(u);
			}
		}
		return -1;
	}
	
	@Override
	public Iterable<UserTest> getUsers() {
		return listUser;
	}

	@Override
	public UserTest addUser(UserTest usr) {
		return (listUser.add(usr)) ? usr : null;
	}

	@Override
	public UserTest getById(Long id) {
		
		for (UserTest u:listUser) {
			if (u.getId()==id) return u;
		}
		
		return null;
	}

	@Override
	public UserTest deleteUser(Long Id) {
		
		int idx = -1;
		UserTest auxUsr = null; 
		
		for (UserTest u:listUser) {
			if (u.getId()==Id) {
				auxUsr = u;
				idx = listUser.indexOf(u);
			}
		}
		if (idx!=-1) listUser.remove(idx);
		return auxUsr;
	}

	@Override
	public UserTest modifyUser(Long id, UserTest usr) {
		
		int idx = getIndexById(id); 
		
		if (idx!=-1) {			
			return listUser.set(idx, usr);
		}
		
		return null;
	}

	@Override
	public Boolean userExists(Long id) {
		return (getIndexById(id)!=-1) ? true : false;
	}
}
