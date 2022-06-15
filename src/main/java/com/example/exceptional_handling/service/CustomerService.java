package com.example.exceptional_handling.service;

import com.example.exceptional_handling.models.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomerDetails();

    public Customer getCustomer(Long id);

    public Customer addCustomer(Customer customer);

    public Customer updateCustomer(Customer customer, Long id);

    public void deleteCustomer(Long id);

}
