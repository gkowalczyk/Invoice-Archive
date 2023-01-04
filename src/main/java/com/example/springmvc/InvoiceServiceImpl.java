package com.example.springmvc;

import com.example.springmvc.repository.AddressRepo;
import com.example.springmvc.repository.ClientRepo;
import com.example.springmvc.repository.InvoiceRepo;
import com.example.springmvc.repository.InvoiceService;
import com.example.springmvc.repository.entity.Address;
import com.example.springmvc.repository.entity.Client;
import com.example.springmvc.repository.entity.Invoice;
import com.example.springmvc.repository.entity.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {


    //public final List<Invoice> invoiceList;
    private final InvoiceRepo invoiceRepo;
    private final ClientRepo clientRepo;
    private final AddressRepo addressRepo;


    public InvoiceServiceImpl(InvoiceRepo invoiceRepo, ClientRepo clientRepo, AddressRepo addressRepo) {
        this.invoiceRepo = invoiceRepo;
        this.clientRepo = clientRepo;
        this.addressRepo = addressRepo;

        //this.invoiceList = new ArrayList<>();

        Product product1 = new Product();
        product1.setProductName("example 1");
        product1.setPrice(new BigDecimal(100));

        Product product2 = new Product();
        product2.setProductName("example 2");
        product2.setPrice(new BigDecimal(200));
        // invoice.setId(1L);

        Invoice invoice = new Invoice();
        Invoice invoice1 = new Invoice();
        invoice.setLocalDate(LocalDate.of(2025, 10, 25));
        invoice.setProductList(List.of(product1, product2));
        invoice1.setLocalDate(LocalDate.of(2025, 10, 25));
        invoice1.setProductList(List.of(product1));

        Client client = new Client();
        Client client1 = new Client();
        client.setClientName("Grzegorz");
        client1.setClientName("Anna");
        //client.setInvoice(invoice); // dla relacji bidirectional, zastąpione przez mapped by
        //clientRepo.save(client); przejmuje cascade = CascadeType.PERSIST
        invoice.setClient(client);
        invoice1.setClient(client1);

        Address address = new Address();
        address.setStreet("Krakowska 99");
        Address address1 = new Address();
        address1.setStreet("Warszawska 99");
        Address address2 = new Address();
        address2.setStreet("Gdańska 99");

        address.setClient(client);
        address1.setClient(client);
        address2.setClient(client1);


        invoiceRepo.saveAll(Arrays.asList(invoice, invoice1));
       addressRepo.saveAll(Arrays.asList(address, address1, address2));

       // invoiceList.add(invoice);

    }
    @Override
    public List<Invoice> getAllInvoice() {
       // return invoiceList;
     return invoiceRepo.findAll();
    }

    @Override
    public void deleteInvoice(Long id) {
        //invoiceList.removeIf(e -> e.getId() == id);
        invoiceRepo.deleteById(id);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
       // Invoice oldInvoice = invoiceList.stream()
          //      .filter(e -> e.getId() == invoice.getId()).findFirst().get();
       // int index = invoiceList.indexOf(oldInvoice);
       // invoiceList.set(index, invoice);
       // Invoice oldInvoice = invoiceRepo.findAll(invoice)
        invoiceRepo.save(invoice);
    }

    @Override
    public void saveInvoice(Invoice invoice) {
       // invoiceList.add(invoice);
        invoiceRepo.save(invoice);
    }
}
