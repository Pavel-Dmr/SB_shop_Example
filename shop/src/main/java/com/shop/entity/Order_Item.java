package com.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Order_Item {

    @Id
    @GeneratedValue
    private Long id;

    private int order_price;

    private int count;

    private LocalDateTime reg_time;

    private LocalDateTime update_time;

    @ManyToOne
}
