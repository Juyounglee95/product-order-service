package com.example.productorderservice.product.adapter;

import org.springframework.stereotype.Component;

import com.example.productorderservice.product.application.port.ProductPort;
import com.example.productorderservice.product.domain.Product;

@Component
class ProductAdapter implements ProductPort {
    private final ProductRepository productRepository;

    ProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(()-> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }
}
