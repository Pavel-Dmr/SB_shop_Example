package com.shop.DTO;

import com.shop.entity.Item_Img;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class Item_Img_DTO {

    private Long id;

    private String name;

    private String ori_name;

    private String url;

    private String repImgYn;

    private static ModelMapper model_mapper = new ModelMapper();

//    메서드

    public static Item_Img_DTO of(Item_Img item_img)
    {
        return model_mapper.map(item_img,Item_Img_DTO.class);
    }

//    DTO와 엔티티간의 변환을 해주는 것이 ModelMapper
//    Item_Img 엔티티 객체를 파라미터로 받아서 Item_Img 객체의 자료혀오가 멤버변수의 이름이
//    같은떄 Item_Img_DTO로 값을 복해서 반환합니다
//    static 메소드로 선언해 Item_Img_DTO 객체를 생성할 수 있다.
}
