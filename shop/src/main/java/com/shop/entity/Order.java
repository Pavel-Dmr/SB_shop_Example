package com.shop.entity;

import com.shop.constant.Order_Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Order_Status order_status;

    private LocalDateTime order_date;

    private LocalDateTime reg_time;

    private LocalDateTime update_time;


//    ================================================= 연관관계 필드

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_key")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL , orphanRemoval = true,fetch = FetchType.LAZY)
//    부모가 삭제 되었을 때 함께 삭제시키는 역할을 수행
    private List<Order_Item> order_item_list = new ArrayList<>();



}
