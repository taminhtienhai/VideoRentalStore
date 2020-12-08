package iuh.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import iuh.software.model.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long>{

	@Query(value = "select * from record", nativeQuery = true)
	Record findRecordById(int idRecord);

}
