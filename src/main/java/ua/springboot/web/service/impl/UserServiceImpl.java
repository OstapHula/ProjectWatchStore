package ua.springboot.web.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.repository.UserRepository;
import ua.springboot.web.service.UserService;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void saveUser(UserEntity entity) {
		String methodName = "saveUser";
		log.debug("Start " + methodName);
		
		String password = entity.getPassword();
		log.debug("Entered password: " + password);
		entity.setPassword(passwordEncoder.encode(password));
		log.debug("encoded password: " + entity.getPassword());
		userRepository.save(entity);
		
		log.debug("End " + methodName);
	}

	@Override
	public UserEntity findUserById(int id) {
		return null;
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		return null;
	}

}
