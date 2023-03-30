package com.example.testhiber.repository;

import com.example.testhiber.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    void deleteByCartId(Long cartId);


}
