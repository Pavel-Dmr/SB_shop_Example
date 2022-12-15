package com.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Item_Img {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ori_name;
    private String name;

    private String url;

    private String repimgYn;

//    연관관계 필드

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_key")
    private Item item;

//    메서드

    public void Update_Item_Img(String ori_name, String name, String url)
    {
        this.ori_name = ori_name;
        this.name = name;
        this.url = url;
    }

//    원본 이미지 파일명, 업데이트할 이미지 파일명, 이미지 경로를 파라미터로 입력 받아서
//    이미지 정보를 업데이트 하는 메소드입니다
}
