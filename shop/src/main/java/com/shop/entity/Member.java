package com.shop.entity;

import com.shop.DTO.Member_DTO;
import com.shop.constant.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Member extends BaseEntity{



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;


    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member Create_Member(Member_DTO member_dto, PasswordEncoder passwordEncoder)
    {
        Member member = new Member();
        member.setName(member_dto.getName());
        member.setEmail(member_dto.getEmail());
        member.setAddress(member_dto.getAddress());

        String password = passwordEncoder.encode(member_dto.getPassword());

        member.setPassword(password);
        member.setRole(Role.ADMIN);

        return member;
    }
}
