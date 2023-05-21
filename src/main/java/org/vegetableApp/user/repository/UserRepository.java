package org.vegetableApp.user.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vegetableApp.user.model.User;
@Repository("userRepository")
public interface UserRepository  extends JpaRepository<User,Integer>{
	public Optional<User> findByUserNameAndPassword(String userName,String password);
	public Optional<User> findByUserName(String name);
}
