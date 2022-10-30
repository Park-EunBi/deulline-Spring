package com.deulline.server.web;

import com.deulline.server.domain.basket.basket;
import com.deulline.server.response.ApiResponse;
import com.deulline.server.service.basket.basketService;
import com.deulline.server.web.dto.basketDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.tools.DocumentationTool;

@RestController
@RequiredArgsConstructor
public class basketController {
    private final basketService basketService;

    /**
     * 사용자 id에 따른 장바구니 항목 조회
     */

    @GetMapping("basket/{userId}")
    public basketDto.basketInfoDto getBasketInfo(@PathVariable(value = "userId") Long userId){
        basket info = basketService.getBasketById(userId);
        basketDto.basketInfoDto basketInfoDto = new basketDto.basketInfoDto(info.getBasket_id(), info.getProductId(), info.getPrice());

        return basketInfoDto;

    }

    /**
     * 사용자가 요청한 상품을 장바구니에 넣기
     */
    @PostMapping("basket/{productId}")
    public ApiResponse createBasket(@PathVariable(value = "productId") Long productId) {
        Long id = basketService.createBasket(productId);
        return ApiResponse.success("data", id);
    }

}
