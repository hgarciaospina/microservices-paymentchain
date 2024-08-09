package com.paymentchain.customer.repositories;

import com.paymentchain.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Henry García Ospina
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
