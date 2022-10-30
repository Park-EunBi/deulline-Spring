package com.deulline.server.service.additional;

import com.deulline.server.domain.additional.additional;
import com.deulline.server.domain.additional.additionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class additionalService {
    private final additionalRepository additionalRepository;


    public additional getAdditional(Long productId) {
        return additionalRepository.getAdditionalById(productId).get();
    }
}
