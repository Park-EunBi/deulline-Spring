package com.deulline.server.service.product;

import com.deulline.server.domain.imgToText.imgToText;
import com.deulline.server.domain.product.product;
import com.deulline.server.domain.product.productRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class productService {
    private final productRepository productRepository;

    /**
     * 상품의 기초 정보 조회
     */

    public product getProductById(Long productId) {
        product info = productRepository.findById(productId).get();

        System.out.println(info);

        return info;
    }

    public product getExtraById(Long productId) {
        return productRepository.findExtraById(productId).get();
    }
}
