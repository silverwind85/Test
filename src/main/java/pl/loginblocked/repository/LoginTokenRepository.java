package pl.loginblocked.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.loginblocked.entity.LoginToken;
import pl.loginblocked.entity.User;



@Repository
public interface LoginTokenRepository extends JpaRepository<LoginToken, Long>{
	LoginToken findByToken(String token);
	LoginToken findByUser(User user);

	
}
