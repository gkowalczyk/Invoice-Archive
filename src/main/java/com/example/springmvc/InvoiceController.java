package com.example.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller

public class InvoiceController {

    final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public String getAllInvoices(Model model) {
        List<Invoice> allInvoices = invoiceService.getAllInvoice();
        model.addAttribute("allInvoices", allInvoices);
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
