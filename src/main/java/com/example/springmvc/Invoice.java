package com.example.springmvc;

//import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
//@NoArgsConstructor
public class Invoice {

    public long id;
    public BigDecimal price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate localDate;
    public String name;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
