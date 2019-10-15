package com.example.demowebrest.service;

import java.util.List;

import com.example.demowebrest.domain.Customer;
import com.example.demowebrest.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAllOrderByName();
    }

    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAllOrderByName(pageable);
    }

    public Customer findOne(Integer id) {
        // omit id validation for simplicity
        return customerRepository.findById(id).orElse(null);
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
