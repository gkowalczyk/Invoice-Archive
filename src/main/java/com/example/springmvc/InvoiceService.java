package com.example.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InvoiceService {

       List<Invoice> getAllInvoice();
       void deleteInvoice(Long id);
       void updateInvoice(Invoice invoice);
       void saveInvoice(Invoice invoice);
   }
