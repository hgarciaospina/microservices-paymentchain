package com.paymentchain.billing.services;

import com.paymentchain.billing.entities.Invoice;
import com.paymentchain.billing.exceptions.InvoiceNotFoundException;
import com.paymentchain.billing.repositories.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<Invoice> findById(Long id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (invoice.isEmpty()) {
            throw new InvoiceNotFoundException("Invoice not found with id " + id);
        }
        return invoice;
    }

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public void deleteById(Long id) {
        if (!invoiceRepository.existsById(id)) {
            throw new InvoiceNotFoundException("Invoice not found with id " + id);
        }
        invoiceRepository.deleteById(id);
    }

    @Override
    public Invoice update(Long id, Invoice invoiceDetails) {
        return invoiceRepository.findById(id).map(invoice -> {
            invoice.setCustomerId(invoiceDetails.getCustomerId());
            invoice.setNumber(invoiceDetails.getNumber());
            invoice.setAmount(invoiceDetails.getAmount());
            invoice.setDetail(invoiceDetails.getDetail());
            return invoiceRepository.save(invoice);
        }).orElseThrow(() -> new InvoiceNotFoundException("Invoice not found with id " + id));
    }
}