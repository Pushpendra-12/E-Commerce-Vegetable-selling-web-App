package org.vegetableApp.user.srevice;

import org.vegetableApp.user.model.User;


public interface UserService {
	public User addUser(User user);
	public User updateUser(User user);
	public User viewUser(Integer userId);
	public User removeUser(Integer userId);
	public User findByUserName(String name);
	
}
