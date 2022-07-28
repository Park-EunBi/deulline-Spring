package com.deulline.server.domain.basket;


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
public class basket {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basket_id;
    private Long product_id;
    private int price;

    private Long user_id;
}
