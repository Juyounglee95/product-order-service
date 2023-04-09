package com.example.productorderservice.product;

import org.springframework.util.Assert;

record UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {
    UpdateProductRequest {
        Assert.hasText("상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인정책은 필수입니다.");
    }
}
