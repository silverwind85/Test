package pl.loginblocked.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.loginblocked.entity.RememberPasswordToken;



@Repository
public interface RememberPasswordTokenRepository extends JpaRepository<RememberPasswordToken, Long> {
	RememberPasswordToken findByToken(String token);
}
