package com.deulline.server.web;

import com.deulline.server.domain.additional.additional;
import com.deulline.server.response.DefaultRes;
import com.deulline.server.response.ResponseMessage;
import com.deulline.server.response.StatusCode;
import com.deulline.server.service.additional.additionalService;
import com.deulline.server.web.dto.additionalDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class additionalController {
    private final additionalService additionalService;

    /**
     * 특이사항 출력 api
     */
    @GetMapping("/additional/{productId}")
    public ResponseEntity getAdditional(@PathVariable(value = "productId") Long productId) {
        additional additional = additionalService.getAdditional(productId);

        additionalDto.additionalInfoDto additionalInfoDto = new additionalDto.additionalInfoDto(additional.getProductId(), additional.getAdditionalData());


        return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS, additionalInfoDto), HttpStatus.OK);
    }
}
