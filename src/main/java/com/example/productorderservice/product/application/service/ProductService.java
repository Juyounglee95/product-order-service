package com.example.productorderservice.product.application.service;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productorderservice.product.application.port.ProductPort;
import com.example.productorderservice.product.domain.Product;

@RestController
@RequestMapping("/products")
public class ProductService {
    private final ProductPort productPort;

    ProductService(final ProductPort productPort) {
        this.productPort = productPort;
        System.out.println("ProductPort = " + productPort.getClass());
    }
    @PostMapping
    @Transactional
    public ResponseEntity addProduct(@RequestBody final AddProductRequest request) {
        final Product product = new Product(request.name(), request.price(), request.discountPolicy());
        productPort.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable final Long productId) {
        Product product = productPort.getProduct(productId);

        final GetProductResponse response =  new GetProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDiscountPolicy());

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{productId}")
    @Transactional
    public ResponseEntity<Void> updateProduct(
            @PathVariable Long productId,
            @RequestBody UpdateProductRequest request) {
        final Product product= productPort.getProduct(productId);
        product.update(request.name(), request.price(), request.discountPolicy());
        productPort.save(product);

        return ResponseEntity.ok().build();
    }
}
