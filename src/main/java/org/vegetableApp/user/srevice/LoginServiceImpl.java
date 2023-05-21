package org.vegetableApp.user.srevice;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vegetableApp.address.repository.AddressRepository;
import org.vegetableApp.dto.LoginToken;
import org.vegetableApp.user.model.User;
import org.vegetableApp.user.repository.UserRepository;



@Service("loginService")
public class LoginServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public User checkLogin(LoginToken loginToken) {
		Optional<User> userOpt = userRepository.findByUserNameAndPassword(loginToken.getUserName(), loginToken.getPassword());
		if(userOpt.isPresent())
			return userOpt.get();
		else
			return null;
	}
	
	
	
	public User getUserByUserId(Integer userid) {
		Optional<User> userOpt = userRepository.findById(userid);
		if(userOpt.isPresent())
			return userOpt.get();
		else
			return null;
	}
	
	public User findByUserName(String name) {
//		User user = new User();
//		name = user.getName();
		Optional<User> opt = userRepository.findByUserName(name);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		addressRepository.save(user.getAddress());
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User viewUser(Integer userId) {
		// TODO Auto-generated method stub
		Optional<User> opt = userRepository.findById(userId);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}



	@Override
	public User removeUser(Integer userId) {
		// TODO Auto-generated method stub
		User use = userRepository.findById(userId).get();
		userRepository.deleteById(userId);
		return use;
	}



	
	
}
