package com.scalerproject.cartmicroservice.cartservice.Service;

import com.scalerproject.cartmicroservice.cartservice.Model.Cart;
import org.springframework.stereotype.Service;

@Service
public class SelfCartService implements CartService{

    @Override
    public Cart getSingleCart(Integer id) {
        return null;
    }
}
