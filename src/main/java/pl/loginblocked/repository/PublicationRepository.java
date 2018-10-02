package pl.loginblocked.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.loginblocked.entity.Category;
import pl.loginblocked.entity.Image;
import pl.loginblocked.entity.Publication;
import pl.loginblocked.entity.Species;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long>{
	List<Publication> findAllByCategory(Category category);
	List<Publication> findAllBySpecies(Species species);
	List<Publication> findAllByCategory(Category category, Pageable pageable);
	List<Publication> findAllBySpecies(Species species, Pageable pageable);
	List<Publication> findAllBySpeciesList(List<Species> speciesList);
	Publication findByImage(Image image);
	long countByCategory(Category category);
	long countBySpecies(Species species);
	Publication findByName(String name);
	
	@Query("select p.id from Publication p join p.speciesList s where s.id in (:speciesIds)")
	List<Long> findAllBySpeciesList(@Param(value = "speciesIds") List<Long> speciesIds, Pageable pageable);
	
	@Query("select count(p.id) from Publication p join p.speciesList s where s.id in (:speciesIds)")
	long countBySpeciesList(@Param(value = "speciesIds") List<Long> speciesIds);
}