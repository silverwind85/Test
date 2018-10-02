package pl.loginblocked.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.loginblocked.entity.ActivationToken;



@Repository
public interface ActivactionTokenRepository extends JpaRepository<ActivationToken, Long>{
	ActivationToken findByToken(String token);
}
