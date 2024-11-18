package com.example.philips.login.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Setter
    private String name;
    @Setter
    private String description;
    @Setter
    private Float price;
    @Setter
    private Long stock;
    @Setter
    private String imagenUrl;

    public ProductEntity(String name, String description,  Float price, Long stock, String imagenUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.imagenUrl = imagenUrl;
    }
}
