package pl.loginblocked.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.loginblocked.entity.Category;
import pl.loginblocked.entity.Publication;
import pl.loginblocked.entity.Species;


@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long>{
	List<Species> findAllByCategory(Category category);
	Species findByName(String name);
	List<Species> findAllByPublications(Publication publications);
}