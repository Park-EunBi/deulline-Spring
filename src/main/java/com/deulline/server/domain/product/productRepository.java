package com.deulline.server.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface productRepository extends JpaRepository<product, Long> {
    @Query(value = "select * from product p where p.product_id =:productId", nativeQuery = true)
    Optional<product> findById(@Param("productId") Long productId);

    @Query(value = "select * from product p where p.product_id = :productId", nativeQuery = true)
    Optional<product> findExtraById(@Param("productId")Long productId);
}
