package iuh.software.repository;

import iuh.software.model.Title;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitleRepository extends JpaRepository<Title, Long> {

    @EntityGraph(attributePaths = {"dvds"})
    List<Title> findAll();
}
