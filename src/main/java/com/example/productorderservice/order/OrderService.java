package com.example.productorderservice.order;

import com.example.productorderservice.product.Product;
import org.springframework.stereotype.Component;

@Component
class OrderService {
    private final OrderPort orderPort;

    OrderService(final OrderPort orderPort) {
        this.orderPort = orderPort;
    }


    public void createOrder(CreateOrderRequest request) {
        final Product product = orderPort.getProductId(request.productId());
        final Order order = new Order(product, request.quantity());
        orderPort.save(order);

    }
}
