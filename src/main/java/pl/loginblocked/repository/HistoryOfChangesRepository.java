package pl.loginblocked.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.loginblocked.entity.HisotyOfChanges;



@Repository
public interface HistoryOfChangesRepository extends JpaRepository<HisotyOfChanges, Long>{
	

}
