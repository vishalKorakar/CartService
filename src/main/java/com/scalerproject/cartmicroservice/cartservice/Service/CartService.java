package com.scalerproject.cartmicroservice.cartservice.Service;

import com.scalerproject.cartmicroservice.cartservice.Model.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

public interface CartService {

    Cart getSingleCart(Integer id);
}
