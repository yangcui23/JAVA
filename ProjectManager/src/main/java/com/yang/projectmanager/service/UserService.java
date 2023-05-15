package com.yang.projectmanager.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.yang.projectmanager.models.LoginUser;
import com.yang.projectmanager.models.User;
import com.yang.projectmanager.repository.UserRepository;



@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());
		
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "This email is already in use!");
		}

		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Both passwords must match!");
		}

		if (result.hasErrors()) {
			return null;

		} else {
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashed);
			return userRepository.save(newUser);
		}
}
	public User login(LoginUser newLogin, BindingResult result) {

		if (result.hasErrors()) {
			return null;
		}

		Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
		if (!potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "Unknown email!");
			return null;
		}

		User user = potentialUser.get();
		if (!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}

		if (result.hasErrors()) {
			return null;
		} else {
			return user;
		}
	}
	
	public List<User> allUsers() {
		return userRepository.findAll();
	}
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public User findById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else
			return null;
	}
	
}
