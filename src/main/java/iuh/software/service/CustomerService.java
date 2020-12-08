package iuh.software.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import iuh.software.model.Customer;

public interface CustomerService {
    Optional<Customer> searchById(Long id);
    Set<Customer> searchByName(String name);
    Set<Customer> findAll();
    List<Customer> getAllCutomer();
	Customer insertCustomer(String name, String phone, LocalDate birth, String email);

}
