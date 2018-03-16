package ua.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import ua.springboot.web.entity.UserEntity;
import ua.springboot.web.entity.enumeration.UserRole;
import ua.springboot.web.repository.UserRepository;

@SpringBootApplication
public class ProjectWatchShopApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ProjectWatchShopApplication.class);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ProjectWatchShopApplication.class, args);
		addAdmin(context);
	}
	
	static void addAdmin(ConfigurableApplicationContext context) {
		String adminEmail = "admin@gmail.com";
		String adminPassword = "123";
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		UserEntity entity = userRepository.findUserByEmail(adminEmail);
		if(entity == null) {
			PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
			
			entity = new UserEntity();
			entity.setEmail(adminEmail);
			entity.setPassword(encoder.encode(adminPassword));
			entity.setRole(UserRole.ROLE_ADMIN);
			
			userRepository.save(entity);
		}
	}
	
}
