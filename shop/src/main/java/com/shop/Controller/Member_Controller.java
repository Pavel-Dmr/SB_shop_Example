package com.shop.Controller;


import com.shop.DTO.Member_DTO;
import com.shop.Service.Member_Service;
import com.shop.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class Member_Controller {

    private final Member_Service member_service;

    private final PasswordEncoder password_encoder;

    @GetMapping(value = "/new")
    public String Member_Form(Model model)
    {
        model.addAttribute("member_dto",new Member_DTO());
        return "Member/Member_Form";
    }

    @PostMapping(value = "/new")
    public String Member_Form(@Valid Member_DTO member_dto, BindingResult binding_result, Model model)
    {
        if(binding_result.hasErrors())
        {
            return "Member/Member_Form";
        }
        try {
            Member member = Member.Create_Member(member_dto, password_encoder);
            member_service.Save_Member(member);
        }
        catch(IllegalStateException e)
        {
            model.addAttribute("error_message",e.getMessage());
            return "Member/Member_Form";
        }

        return "redirect:/";
    }

    @GetMapping(value="/login")
    public String Login_Member()
    {
        return "/Member/Member_Login_Form";
    }

    @GetMapping(value ="/login/error")
    public String Login_Error(Model model)
    {
        model.addAttribute("login_error_msg","아이디 또는 비밀번호가 틀렸습니다");
        return "/Member/Member_Login_Form";
    }
}
