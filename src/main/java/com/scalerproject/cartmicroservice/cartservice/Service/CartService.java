package com.scalerproject.cartmicroservice.cartservice.Service;

import com.scalerproject.cartmicroservice.cartservice.Model.Cart;
import com.scalerproject.cartmicroservice.cartservice.Model.ProductQuantity;
import com.scalerproject.cartmicroservice.cartservice.Model.Products;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

public interface CartService {

    Cart getSingleCart(Integer id);
    List<Cart> getAllCart();
    List<Cart> getCartForUserId(Integer userId);
    Cart addNewCart(Integer userid, Date date, List<ProductQuantity> products);
//    Cart updateCart(Integer userid, Date date, List<Products> products, Integer cartid);
    Cart deleteCart(Integer cartId);
}
