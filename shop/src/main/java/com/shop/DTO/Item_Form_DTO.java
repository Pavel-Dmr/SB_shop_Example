package com.shop.DTO;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Item_Form_DTO {

    private long id;

    @NotBlank(message = "상품명은 필수 입력값 입니다.")
    private String name;

    @NotBlank(message = "가격은 필수 입력 값입니다.")
    private Integer price;

    @NotBlank(message = "상품 상세는 필수 입력 값입니다.")
    private String detail;

    @NotNull(message = "재고는 필수 입력 값입니다")
    private Integer stock_number;

    private ItemSellStatus sell_status;

    private List<Item_Img_DTO> item_img_dto_List = new ArrayList<>();

    private List<Long> item_img_id_list;

    private static ModelMapper model_mapper = new ModelMapper();
    public Item_Form_DTO()
    {
        item_img_id_list = new ArrayList<>();
    }

    public Item Create_Item()
    {
        return model_mapper.map(this,Item.class);
    }
    public static Item_Form_DTO of(Item item)
    {
        return model_mapper.map( item,  Item_Form_DTO.class);
    }
}
