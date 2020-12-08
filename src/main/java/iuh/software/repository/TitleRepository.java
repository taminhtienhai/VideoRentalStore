package iuh.software.repository;

import java.util.Optional;

import iuh.software.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import iuh.software.model.DVD;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {
}
