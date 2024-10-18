package com.Practice.Web.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Entity
@Component
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue

    private int productId;
    private String productName;
}
