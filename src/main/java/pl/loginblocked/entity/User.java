package pl.loginblocked.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.loginblocked.entity.type.Role;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	private String email;
	private Role role;
	private boolean active;
	@Column( columnDefinition = "Integer default 0")
	private Integer badAuthenticationCount;
}
