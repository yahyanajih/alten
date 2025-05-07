package com.example.producttrial.Repository;


import com.example.producttrial.Entity.Product;
import com.example.producttrial.Entity.Product.InventoryStatus;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

    @Component
    public class InitH2DB {

        private final ProductRepository productRepository;

        public InitH2DB(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @PostConstruct
        public void seedDatabase() {
            if (productRepository.count() == 0) {
                List<Product> products = List.of(
                        Product.builder()
                                .code("P001")
                                .name("Laptop")
                                .description("High-end gaming laptop")
                                .image("laptop.jpg")
                                .category("Electronics")
                                .price(1499.99)
                                .quantity(10)
                                .internalReference("ALT-001")
                                .shellId(1001L)
                                .inventoryStatus(InventoryStatus.INSTOCK)
                                .rating(5)
                                .createdAt(Instant.now())
                                .updatedAt(Instant.now())
                                .build(),

                        Product.builder()
                                .code("P002")
                                .name("Smartphone")
                                .description("Latest model smartphone")
                                .image("smartphone.jpg")
                                .category("Electronics")
                                .price(999.99)
                                .quantity(20)
                                .internalReference("ALT-002")
                                .shellId(1002L)
                                .inventoryStatus(InventoryStatus.LOWSTOCK)
                                .rating(4)
                                .createdAt(Instant.now())
                                .updatedAt(Instant.now())
                                .build(),

                        Product.builder()
                                .code("P003")
                                .name("Headphones")
                                .description("Noise-cancelling headphones")
                                .image("headphones.jpg")
                                .category("Accessories")
                                .price(199.99)
                                .quantity(0)
                                .internalReference("ALT-003")
                                .shellId(1003L)
                                .inventoryStatus(InventoryStatus.OUTOFSTOCK)
                                .rating(3)
                                .createdAt(Instant.now())
                                .updatedAt(Instant.now())
                                .build()
                );

                productRepository.saveAll(products);
            }
        }
    }
