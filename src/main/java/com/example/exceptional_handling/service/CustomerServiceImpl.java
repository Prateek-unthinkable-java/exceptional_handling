package com.example.exceptional_handling.service;

import com.example.exceptional_handling.exceptions.CustomerAlreadyExistsException;
import com.example.exceptional_handling.exceptions.EmptyListException;
import com.example.exceptional_handling.exceptions.NoSuchCustomerExistsException;
import com.example.exceptional_handling.models.Customer;
import com.example.exceptional_handling.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomerDetails(){
        boolean count = customerRepository.findAll().isEmpty();
        if(!count)
            return customerRepository.findAll();
        else
            throw new EmptyListException("Customer list is empty, Please add some customers!");
    }

    public Customer getCustomer(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new NoSuchCustomerExistsException("No customer present with this id: "+id));
    }

    public Customer addCustomer(Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getCustId()).orElse(null);
        if (existingCustomer == null)
            return customerRepository.save(customer);
        else
            throw new CustomerAlreadyExistsException("Customer already exists with id: "+customer.getCustId());
    }

    public Customer updateCustomer(Customer customer, Long id){
        Customer cst = customerRepository.findById(id).orElse(null);
        if(cst == null)
            throw new NoSuchCustomerExistsException("There is no information with this id: "+id);
        else {
            Customer cust = customerRepository.findById(id).get();
            cust.setCustId(customer.getCustId());
            cust.setCustName(customer.getCustName());
            cust.setTotalBill(customer.getTotalBill());
            cust.setPayedBill(customer.getPayedBill());
            cust.setRestBill(customer.getRestBill());
            cust.setCityOfCustomer(customer.getCityOfCustomer());
            customerRepository.save(cust);
            return cust;
        }
    }

    public void deleteCustomer(Long id){
        Customer cust = customerRepository.findById(id).orElse(null);
        if(cust == null)
            throw new NoSuchCustomerExistsException("There is no information with this id: "+id+" to delete.");
        else {
            Customer customer = customerRepository.findById(id).get();
            customerRepository.delete(customer);
        }
    }
}
