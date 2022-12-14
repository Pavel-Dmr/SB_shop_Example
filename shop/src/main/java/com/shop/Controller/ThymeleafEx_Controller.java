package com.shop.Controller;

import com.shop.DTO.Item_DTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/thymeleaf")
public class ThymeleafEx_Controller {

    @GetMapping("/ex01")
    public String Thymeleaf_Example01(Model model)
    {
        model.addAttribute("data","타임리프 예제01");

        return "Thymeleaf_EX/Thymeleaf_01";
    }

    @GetMapping("/ex02")
    public String Thymeleaf_Example02(Model model)
    {
        Item_DTO item_dto = new Item_DTO();
        item_dto.setDetail("상품상세설명");
        item_dto.setName("테스트 상품1");
        item_dto.setPrice(10000);
        item_dto.setReg_time(LocalDateTime.now());

        model.addAttribute("item_dto",item_dto);
        return "Thymeleaf_EX/Thymeleaf_02";
    }

    @GetMapping("/ex03")
    public String Thymeleaf_Example03(Model model)
    {
        List<Item_DTO> item_dto_list = new ArrayList<>();

        for(int i=1; i<=10; i++)
        {
            Item_DTO item_dto = new Item_DTO();
            item_dto.setDetail("상품상세설명" + i);
            item_dto.setName("테스트 상품" + i);
            item_dto.setPrice(1000*i);
            item_dto.setReg_time(LocalDateTime.now());

            item_dto_list.add(item_dto);
        }

        model.addAttribute("item_dto_list",item_dto_list);

        return "Thymeleaf_EX/Thymeleaf_03";
    }

    @GetMapping(value = "/ex05")
    public String Thymeleaf_Example05()
    {
        return "Thymeleaf_EX/Thymeleaf_05";
    }

    @GetMapping(value = "/ex06")
    public String Thymeleaf_Example06(String param1 ,String param2,Model model)
    {
        model.addAttribute("param1",param1);
        model.addAttribute("param2",param2);

        return "Thymeleaf_EX/Thymeleaf_06";
    }

    @GetMapping(value="/ex07")
    public String Thymeleaf_Example07()
    {
        return "Thymeleaf_EX/Thymeleaf_07";
    }
}
