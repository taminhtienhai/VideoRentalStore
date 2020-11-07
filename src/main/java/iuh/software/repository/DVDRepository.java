package iuh.software.repository;

import iuh.software.model.DVD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DVDRepository extends JpaRepository<DVD, Long> {
}
