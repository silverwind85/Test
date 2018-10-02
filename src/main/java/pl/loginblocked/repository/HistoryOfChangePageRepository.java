package pl.loginblocked.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import pl.loginblocked.entity.HisotyOfChanges;



public interface HistoryOfChangePageRepository extends PagingAndSortingRepository<HisotyOfChanges, Long>{

}
