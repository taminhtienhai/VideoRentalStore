package iuh.software.repository;

import iuh.software.model.DVD;
import iuh.software.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TitleRepository extends JpaRepository<Title, Long> {
}
