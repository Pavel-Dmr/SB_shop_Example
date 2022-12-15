package com.shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Item_Controller {
    @GetMapping(value = "/admin/item/new")
    public String Item_Form()
    {
        return "/Item/Item_Form";
    }
}
