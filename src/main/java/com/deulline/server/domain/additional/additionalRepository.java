package com.deulline.server.domain.additional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface additionalRepository extends JpaRepository<additional, Long> {
    @Query(value = "select * from additional a " +
            "where a.product_id = :productId", nativeQuery = true)
    Optional<additional> getAdditionalById(@Param(value = "productId") Long productId);
}
