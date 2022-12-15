package com.shop.repository;

import com.shop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cart_Repository extends JpaRepository<Cart,Long> {
    Cart findByMember_key(Long member_key);

}
