package com.example.producttrial.Service;

import com.example.producttrial.Controller.dto.ProductDto;
import com.example.producttrial.Repository.Entity.ProductEntity;
import com.example.producttrial.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductEntity> getAll() {
        return repository.findAll();
    }

    public Optional<ProductEntity> getById(Long id) {
        return repository.findById(id);
    }

    public ProductEntity create(ProductEntity product) {
        product.setCreatedAt(Instant.now());
        product.setUpdatedAt(Instant.now());
        return repository.save(product);
    }

    public ProductEntity update(Long id, ProductEntity updated) {
        return repository.findById(id).map(existing -> {
            updated.setId(id);
            updated.setCreatedAt(existing.getCreatedAt());
            updated.setUpdatedAt(Instant.now());
            return repository.save(updated);
        }).orElseThrow();
    }

    public ProductEntity partialUpdate(Long id, ProductDto dto) {
        return repository.findById(id).map(product -> {
            if (dto.getName() != null) product.setName(dto.getName());
            if (dto.getPrice() != null) product.setPrice(dto.getPrice());
            if (dto.getInventoryStatus() != null)
                product.setInventoryStatus(ProductEntity.InventoryStatus.valueOf(dto.getInventoryStatus()));
            product.setUpdatedAt(Instant.now());
            return repository.save(product);
        }).orElseThrow();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
