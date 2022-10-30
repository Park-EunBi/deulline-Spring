package com.deulline.server.domain.additional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "basket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class additional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "additional_id", unique = true)
    private Long id;

    private Long productId;

    private String additionalData;
}
