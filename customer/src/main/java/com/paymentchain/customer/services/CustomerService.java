package com.paymentchain.customer.services;

import com.paymentchain.customer.entities.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer save(Customer customer);
    void deleteById(Long id);
    Customer update(Long id, Customer customerDetails); // Agregar este método
}