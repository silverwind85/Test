package pl.loginblocked.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class RememberPasswordToken {
	 	@Id
	    @GeneratedValue
	    private Long id;
	    private String token;
	    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	    @JoinColumn(name = "userId")
	    private User user;
	    private LocalDateTime expirationDateTime;
	    
	    public RememberPasswordToken() {
	    }

	    public RememberPasswordToken(String token, User user) {
	        this.token = token;
	        this.user = user;
	        this.expirationDateTime = LocalDateTime.now().plusMinutes(3);
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((expirationDateTime == null) ? 0 : expirationDateTime.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((token == null) ? 0 : token.hashCode());
			result = prime * result + ((user == null) ? 0 : user.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RememberPasswordToken other = (RememberPasswordToken) obj;
			if (expirationDateTime == null) {
				if (other.expirationDateTime != null)
					return false;
			} else if (!expirationDateTime.equals(other.expirationDateTime))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (token == null) {
				if (other.token != null)
					return false;
			} else if (!token.equals(other.token))
				return false;
			if (user == null) {
				if (other.user != null)
					return false;
			} else if (!user.equals(other.user))
				return false;
			return true;
		}

	   
}
