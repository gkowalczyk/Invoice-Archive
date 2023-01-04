package com.example.springmvc.repository;

import com.example.springmvc.repository.entity.Client;
import com.example.springmvc.controller.dto.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

      @Query("select new com.example.springmvc.controller.dto.OrderDto(sum(product.price), client.clientName, invoice.localDate) " +
            "from Client client " +
            "join client.invoice invoice " +
            "join invoice.productList product group by client.clientName")
      List<OrderDto> getAllOrders();
}
