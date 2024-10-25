package com.Practice.Web.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data//Basic methods like get/setter/tostring etc
@AllArgsConstructor
@Entity //create database like table name etc
@Component //used for autowiring and is responsible
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue

    private int productId;
    private String productName;
}
