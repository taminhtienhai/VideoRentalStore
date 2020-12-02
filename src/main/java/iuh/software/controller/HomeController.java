package iuh.software.controller;

import iuh.software.model.Customer;
import iuh.software.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@Slf4j
@Controller
public class HomeController {

    private final CustomerService customerService;

    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/all/{limit}")
    public ResponseEntity<Set<Customer>> findAllCustomer (@PathVariable int limit) {
        log.info("findAllCustomer execute...");
        return ResponseEntity.ok(this.customerService.findAll());
    }
}
