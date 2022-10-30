package com.deulline.server.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class additionalDto {

    @Data
    @AllArgsConstructor
    public static class additionalInfoDto{
        private Long productId;
        private String additionalData;
    }
}
