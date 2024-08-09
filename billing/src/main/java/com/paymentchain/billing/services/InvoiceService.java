package com.paymentchain.billing.services;

import com.paymentchain.billing.entities.Invoice;
import java.util.List;
import java.util.Optional;

public interface InvoiceService {
    List<Invoice> findAll();
    Optional<Invoice> findById(Long id);
    Invoice save(Invoice invoice);
    void deleteById(Long id);
    Invoice update(Long id, Invoice invoiceDetails);
}