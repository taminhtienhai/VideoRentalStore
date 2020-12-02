package iuh.software.service.impl;

import iuh.software.model.Customer;
import iuh.software.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Optional<Customer> searchById(Long id) {
        return Optional.empty();
    }

    @Override
    public Set<Customer> searchByName(String name) {
        return null;
    }

    @Override
    public Set<Customer> findAll() {
        Set<Customer> mock = new HashSet<>();
        mock.add(new Customer("Hai", "123"));
        return mock;
    }
}
