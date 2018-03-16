package ua.springboot.web.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

import ua.springboot.web.entity.enumeration.UserRole;
import ua.springboot.web.validator.CheckPasswordsMatch;

@NoArgsConstructor
@Getter @Setter
@CheckPasswordsMatch
public class RegisterRequest {

	@NotEmpty private String email;
	@NotEmpty private String password;
	@NotEmpty private String passwordConfirmation;
	@NotEmpty private String firstName;
	@NotEmpty private String lastName;
	@NotEmpty private String address;
	@NotEmpty private String telephone;
	private UserRole role;
	
}
