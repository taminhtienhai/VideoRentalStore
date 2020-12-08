package iuh.software.repository;

import iuh.software.model.DVD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DVDRepository extends JpaRepository<DVD, Long> {
}
