package com.example.exceptional_handling.controller;

import com.example.exceptional_handling.models.Customer;
import com.example.exceptional_handling.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public List<Customer> getCustomerDetails(){
        return customerService.getAllCustomerDetails();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") Long id){
        return customerService.getCustomer(id);
    }

    @PostMapping("/")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") Long id){
        return customerService.updateCustomer(customer, id);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomerById(@PathVariable("id") Long id){
            customerService.deleteCustomer(id);
            return "Customer deleted.";
    }
}
