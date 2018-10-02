package pl.loginblocked.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.loginblocked.entity.Image;



@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}