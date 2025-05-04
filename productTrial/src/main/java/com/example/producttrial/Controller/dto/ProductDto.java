package com.example.producttrial.Controller.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String code;
    private String name;
    private String description;
    private String image;
    private String category;
    private Double price;
    private Integer quantity;
    private String internalReference;
    private Long shellId;
    private String inventoryStatus; // "INSTOCK" | "LOWSTOCK" | "OUTOFSTOCK"
    private Integer rating;
    private Long createdAt;
    private Long updatedAt;
}
