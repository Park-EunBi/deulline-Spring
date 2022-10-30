package com.deulline.server.web;

import com.deulline.server.domain.imgToText.imgToText;
import com.deulline.server.domain.product.product;
import com.deulline.server.response.ApiResponse;
import com.deulline.server.response.DefaultRes;
import com.deulline.server.response.ResponseMessage;
import com.deulline.server.response.StatusCode;
import com.deulline.server.service.product.productService;
import com.deulline.server.web.dto.imgToTextDto;
import com.deulline.server.service.imgToText.imgToTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class imgToTextController {

    private final productService productService;

    /**
     * 추가 정보 요청에 대한 ocr 전체 세부 정보
     */
    @GetMapping("extra/{productId}")
    public ResponseEntity getExtraOcr(@PathVariable(value = "productId") Long productId) {
        product info = productService.getExtraById(productId);
        imgToTextDto.extraInfoDto extraInfoDto = new imgToTextDto.extraInfoDto(info.getProduct_id(), info.getProduct_data());

        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS, extraInfoDto), HttpStatus.OK);
    }


}
