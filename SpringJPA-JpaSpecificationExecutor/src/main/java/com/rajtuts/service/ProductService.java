package com.rajtuts.service;

import com.rajtuts.dao.ProductRepository;
import com.rajtuts.entity.Product;
import com.rajtuts.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts(String name, String category, Double minPrice, Double maxPrice) {
        Specification<Product> spec = ProductSpecification.build(name, category, minPrice, maxPrice);
        return productRepository.findAll(spec);
    }
}
