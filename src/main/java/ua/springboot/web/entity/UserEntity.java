package ua.springboot.web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.entity.enumeration.UserRole;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter @Setter
public class UserEntity extends BaseEntity {
	
	private String email;
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	private String address;
	private String telephone;
		
	@Column(name = "image_path")
	private String imagePath;
	private UserRole role;
	
	@OneToMany(mappedBy = "user", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH })
	private List<OrderEntity> orders = new ArrayList<>();
	
	
}
