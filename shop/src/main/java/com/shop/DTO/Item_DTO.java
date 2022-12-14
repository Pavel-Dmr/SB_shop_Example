package com.shop.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Item_DTO {
    private Long id;

    private String name;

    private Integer price;

    private String detail;

    private String sell_status;

    private LocalDateTime reg_time;

    private LocalDateTime update_time;
}
