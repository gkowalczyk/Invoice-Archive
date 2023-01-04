package com.example.springmvc.repository.entity;

//import lombok.NoArgsConstructor;

import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate localDate;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Client client;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> productList;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;

    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
