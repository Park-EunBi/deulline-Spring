package com.deulline.server.web;

import com.deulline.server.domain.product.product;
import com.deulline.server.response.DefaultRes;
import com.deulline.server.response.ResponseMessage;
import com.deulline.server.response.StatusCode;
import com.deulline.server.service.product.productService;
import com.deulline.server.web.dto.productDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class productController {
    private final productService productService;
    /**
     * 상품의 기초 정보 조회
     */

    @GetMapping("product/{category}")
    public ResponseEntity getProductInfo(@PathVariable(value = "category") String category){

        product info = productService.getProductById(category);
        productDto.productInfoDto productInfoDto = new productDto.productInfoDto(info.getProduct_id(), info.getProduct_name(), info.getPrice(), info.getReview_count(), info.getRanking());

        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS, productInfoDto), HttpStatus.OK);
    }
}
