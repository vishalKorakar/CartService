package com.scalerproject.cartmicroservice.cartservice.Repository;

import com.scalerproject.cartmicroservice.cartservice.Model.Cart;
import com.scalerproject.cartmicroservice.cartservice.Model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface CartRepo extends MongoRepository<Cart, Integer>{

    Cart getCartById(Integer id);
    Cart save(Cart cart);

}
