package iuh.software.service;

import iuh.software.model.Customer;

import java.util.Optional;
import java.util.Set;

public interface CustomerService {
    Optional<Customer> searchById(Long id);
    Set<Customer> searchByName(String name);
    Set<Customer> findAll();
}
