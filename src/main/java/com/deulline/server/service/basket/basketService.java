package com.deulline.server.service.basket;

import com.deulline.server.domain.basket.basket;
import com.deulline.server.domain.basket.basketRepository;
import com.deulline.server.domain.product.product;
import com.deulline.server.domain.product.productRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class basketService {
    private final basketRepository basketRepository;
    private final productRepository productRepository;

    /**
     * 사용자 id에 따른 장바구니 항목 조회
     */
    public basket getBasketById(Long userId){
        basket info = basketRepository.findById(userId).get();

        System.out.println(info);

        return info;
    }

    /**
     * 사용자가 요청한 상품을 장바구니에 넣기
     */
    @Transactional
    public Long createBasket(Long productId) {
        product product = productRepository.findById(productId).get();

        //장바구니 생성
        basket basket = new basket();
        basket.setProductId(productId);
        basket.setPrice(product.getPrice());

        //회원가입 기능 없음 -> null 값으로 채우기
        basket.setUserId(0L);
        basket save = basketRepository.save(basket);

        return save.getBasket_id();
    }
}
