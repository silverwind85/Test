package pl.loginblocked.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.loginblocked.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	Category findByName(String name);

}

