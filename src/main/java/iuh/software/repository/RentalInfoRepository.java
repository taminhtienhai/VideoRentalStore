package iuh.software.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import iuh.software.model.RentalInfo;

public interface RentalInfoRepository extends JpaRepository<RentalInfo, Long> {

	@Modifying
	@Query(value = "update rental_info set returnDate=CURRENT_TIME() where id=:id", nativeQuery = true)
	void updateReturnDateById(Long id);
}
