package iuh.software.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import iuh.software.model.RecordStatus;

@Repository
public interface RecordStatusRepository extends JpaRepository<RecordStatus, Long> {

	@Query(value = "select * from record_status", nativeQuery = true)
	Optional<RecordStatus> findById(int idStatus);

}
