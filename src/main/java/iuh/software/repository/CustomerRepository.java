package iuh.software.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

import iuh.software.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "",
            nativeQuery = true)
    List<Customer> findByEmail(String email);

    @Query(value = "select * from customer", nativeQuery = true)
	List<Customer> findCustomer(String email);
}
