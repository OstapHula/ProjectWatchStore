package ua.springboot.web.service;

import ua.springboot.web.entity.UserEntity;

public interface UserService {

	void saveUser(UserEntity entity);
	
	UserEntity findUserById(int id);
	
	UserEntity findUserByEmail(String email);
}
