package iuh.software.service;

import iuh.software.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TitleService {

    void saveAllCustomer(List<Customer> customers);
}
