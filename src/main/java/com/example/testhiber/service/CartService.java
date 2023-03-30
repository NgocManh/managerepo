package com.example.testhiber.service;

import com.example.testhiber.model.Cart;
import com.example.testhiber.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Transactional
    public void delete(Long id)
    {
        cartRepository.deleteByCartId(id);
    }

    public void create(Cart cart)
    {
        cartRepository.save(cart);
    }
}
