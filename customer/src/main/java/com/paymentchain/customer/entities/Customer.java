package com.paymentchain.customer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Customer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @NotEmpty(message = "Name is required")
   @Pattern(regexp = "^([A-Z][a-z]+)( [A-Z][a-z]+)*$", message = "Name must be in proper case with only letters and single spaces between names")
    
    private String name;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    private String phone;
}