package com.shop.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Cart_Item {

    @Id
    @GeneratedValue
    private Long id;

    private int count;


    @ManyToOne
    @JoinColumn(name="cart_key")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_key")
    private Item item;



}
