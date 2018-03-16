package ua.springboot.web.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import ua.springboot.web.domain.RegisterRequest;
import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.entity.enumeration.UserRole;

public interface UserMapper {

	public static User toSecurityUser(UserEntity entity) {
		return new User(entity.getEmail(), entity.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(entity.getRole())));
	}
	
	public static UserEntity RegisterToUser (RegisterRequest request){
		UserEntity entity = new UserEntity();
		
		entity.setEmail(request.getEmail());
		entity.setPassword(request.getPassword());
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setTelephone(request.getTelephone());
		entity.setAddress(request.getAddress());
		entity.setRole(UserRole.ROLE_USER);
		entity.setEmail(request.getEmail());
		
		return entity;
	}
	
}
