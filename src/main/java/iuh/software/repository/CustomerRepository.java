package iuh.software.repository;

import iuh.software.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    @Query(value = "",
            nativeQuery = true)
    List<Customer> findByEmail(String email);
}
