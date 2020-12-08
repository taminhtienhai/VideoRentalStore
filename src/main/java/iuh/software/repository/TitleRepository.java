package iuh.software.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import iuh.software.model.DVD;

@Repository
public interface DVDRepository extends JpaRepository<DVD, Long> {

	@Query(value = "select * from dvd", nativeQuery = true)
	Optional<DVD> findDvDById(int idDVD);
}
