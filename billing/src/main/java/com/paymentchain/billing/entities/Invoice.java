package com.paymentchain.billing.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author Henry García Ospina
 */
@Entity
@Data
public class Invoice {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private long id;
   @NotNull(message = "customer id is required")
   private long customerId;
   @NotEmpty(message = "number invoice is required")
   @NotNull(message = "number invoice is required")
   private String number;
   @NotEmpty(message = "detail invoice is required")
   @NotNull(message = "detail invoice is required")
   private String detail;
   @NotNull(message = "amount invoice is required")
   private double amount;  
}