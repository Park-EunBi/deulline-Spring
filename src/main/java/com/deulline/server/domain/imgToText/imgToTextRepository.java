package com.deulline.server.domain.imgToText;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface imgToTextRepository extends JpaRepository<imgToText, Long> {

    @Query(value = "select * from imgtotext i where i.product_id = :productId", nativeQuery = true)
    Optional<imgToText> findById(@Param(value = "productId") Long productId);
}
