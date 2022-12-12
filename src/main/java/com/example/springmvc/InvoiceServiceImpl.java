package com.example.springmvc;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    public final List<Invoice> invoiceList;

    public InvoiceServiceImpl() {
        this.invoiceList = new ArrayList<>();
        Invoice invoice = new Invoice();
        invoice.setId(1L);
        invoice.setLocalDate(LocalDate.of(2025, 10, 25));
        invoice.setPrice(new BigDecimal(100));
        invoice.setName("example");
        invoiceList.add(invoice);
    }

    @Override
    public List<Invoice> getAllInvoice() {
        return invoiceList;
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceList.removeIf(e -> e.getId() == id);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        Invoice oldInvoice = invoiceList.stream()
                .filter(e -> e.getId() == invoice.getId()).findFirst().get();
        int index = invoiceList.indexOf(oldInvoice);
        invoiceList.set(index, invoice);
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        invoiceList.add(invoice);
    }
}
