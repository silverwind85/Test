package pl.loginblocked.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VerificationToken {
    @Id
    @GeneratedValue
    private Long id;
    private String token;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userId", unique = true)
    private User user;
    private LocalDateTime expirationDateTime;

    public VerificationToken() {
    }

    public VerificationToken(String token, User user) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VerificationToken that = (VerificationToken) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        return expirationDateTime != null ? expirationDateTime.equals(that.expirationDateTime) : that.expirationDateTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (expirationDateTime != null ? expirationDateTime.hashCode() : 0);
        return result;
    }
}
