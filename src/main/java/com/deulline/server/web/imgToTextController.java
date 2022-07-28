package com.deulline.server.web;

import com.deulline.server.domain.imgToText.imgToText;
import com.deulline.server.response.ApiResponse;
import com.deulline.server.web.dto.imgToTextDto;
import com.deulline.server.service.imgToText.imgToTextService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class imgToTextController {

    private final imgToTextService imgToTextService;

    /**
     * 추가 정보 요청에 대한 ocr 전체 세부 정보
     */
    @GetMapping("extra/{productId}")
    public ApiResponse getExtraOcr(@PathVariable(value = "productId") Long productId) {
        imgToText info = imgToTextService.getExtraById(productId);
        imgToTextDto.extraInfoDto extraInfoDto = new imgToTextDto.extraInfoDto(info.getId(), info.getImg_to_text());

        return ApiResponse.success("data", extraInfoDto);
    }


}
