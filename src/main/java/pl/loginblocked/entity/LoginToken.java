package pl.loginblocked.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LoginToken {
	@Id
    @GeneratedValue
    private Long id;
    private String token;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "userId")
    private User user;
    private LocalDateTime expirationDateTime;
    
	public LoginToken(String token, User user) {
		super();
		this.token = token;
		this.user = user;
		this.expirationDateTime = LocalDateTime.now().plusMinutes(3);
	}
	public LoginToken() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDateTime getExpirationDateTime() {
		return expirationDateTime;
	}
	public void setExpirationDateTime(LocalDateTime expirationDateTime) {
		this.expirationDateTime = expirationDateTime;
	}
    
    

}
