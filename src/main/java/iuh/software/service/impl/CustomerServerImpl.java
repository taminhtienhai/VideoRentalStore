package iuh.software.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.software.model.Customer;
import iuh.software.repository.CustomerRepository;
import iuh.software.service.CustomerService;


@Service
public class CustomerServerImpl implements CustomerService{

@Autowired
private CustomerRepository customerRepository;

	@Override
	public Optional<Customer> searchById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Customer> searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer insertCustomer(String name, String phone, LocalDate birth, String email) {
		
		 Customer customer = new Customer();
		 
	        customer.setName(name);
	        customer.setPhone(phone);
	        customer.setBirth(birth);
	        customer.setEmail(email);
	        
	        customerRepository.save(customer);
	        return customer;
	}

	@Override
	public List<Customer> getAllCutomer() {
		// TODO Auto-generated method stub
		return null;
	}




 
}
