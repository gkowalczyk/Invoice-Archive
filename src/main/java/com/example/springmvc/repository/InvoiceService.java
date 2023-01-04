package com.example.springmvc.repository;

import com.example.springmvc.repository.entity.Invoice;

import java.util.List;


public interface InvoiceService {

       List<Invoice> getAllInvoice();
       void deleteInvoice(Long id);
       void updateInvoice(Invoice invoice);
       void saveInvoice(Invoice invoice);
   }
