package com.example.producttrial.Controller;

import com.example.producttrial.Entity.Product;
import com.example.producttrial.Service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Product create(@RequestBody Product product) {
        return service.save(product);
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable Integer id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
