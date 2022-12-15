package com.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Cart {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



//  ======================================  연관관계 필드 라인

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_key")
    private Member member;


}
