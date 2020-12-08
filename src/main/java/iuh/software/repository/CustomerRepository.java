package iuh.software.repository;

import iuh.software.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "",
            nativeQuery = true)
    List<Customer> findByEmail(String email);

    @Query(value = "select * from customer", nativeQuery = true)
	List<Customer> findCustomer(String email);
}
