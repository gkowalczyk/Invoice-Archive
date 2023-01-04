package com.example.springmvc.controller;

import com.example.springmvc.controller.dto.OrderDto;
import com.example.springmvc.repository.ClientRepo;
import com.example.springmvc.repository.InvoiceService;
import com.example.springmvc.repository.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller

public class InvoiceController {

   private final InvoiceService invoiceService;
   @Autowired
   private ClientRepo clientRepo;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public String getAllOrders(Model model) {
        List<OrderDto> allOrders = clientRepo.getAllOrders();
        model.addAttribute("allOrders", allOrders);
        return "gui";
    }

    @PostMapping("/save")
    public String saveInvoice(@ModelAttribute Invoice invoice) {
        invoiceService.saveInvoice(invoice);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteInvoice(@RequestParam Long id) {
        invoiceService.deleteInvoice(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editInvoice(@ModelAttribute Invoice invoice) {
        invoiceService.updateInvoice(invoice);
         return "redirect:/";
    }
}
