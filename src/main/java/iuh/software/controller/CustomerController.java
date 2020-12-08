package iuh.software.controller;

import iuh.software.common.CommonResponse;
import iuh.software.template.Response;
import iuh.software.model.Customer;
import iuh.software.repository.CustomerRepository;
import iuh.software.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository cusRepo;
    private final CustomerService cusSer;

    public CustomerController(CustomerRepository cusRepo, CustomerService cusSer) {
        this.cusRepo = cusRepo;
        this.cusSer = cusSer;
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<Response> insert(@RequestBody Customer customer) {
        this.cusRepo.save(customer);
        return CommonResponse.OK;
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Long id) {
        this.cusRepo.deleteById(id);
        return CommonResponse.OK;
    }

    @GetMapping(value = "/update")
    public ResponseEntity<Response> update(@PathVariable("id") Long id) {
        //this.cusRepo.save(id);
        return CommonResponse.OK;
    }
}
