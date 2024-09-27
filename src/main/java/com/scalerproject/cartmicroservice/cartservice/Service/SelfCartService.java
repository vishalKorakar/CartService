package com.scalerproject.cartmicroservice.cartservice.Service;

import com.scalerproject.cartmicroservice.cartservice.Model.Cart;
import com.scalerproject.cartmicroservice.cartservice.Model.Products;
import com.scalerproject.cartmicroservice.cartservice.Repository.CartRepo;
import org.springframework.stereotype.Service;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("selfcartservice")
public class SelfCartService implements CartService{

    private CartRepo cartRepo;
    private  SequenceGeneratorService sequenceGenerator;

    public SelfCartService(CartRepo cartRepo, SequenceGeneratorService sequenceGenerator) {
        this.cartRepo = cartRepo;
        this.sequenceGenerator = sequenceGenerator;
    }

//    @Override
//    public Cart getSingleCart(Integer id) {
//        Cart c = cartRepo.findByCartId(id);
//        return null;
//    }
//
//    @Override
//    public List<Cart> getAllCart() {
//        return List.of();
//    }
//
//    @Override
//    public List<Cart> getCartForUserId(Integer userId) {
//        return List.of();
//    }

    @Override
    public Cart addNewCart(Integer userid, Date date, List<Products> products) {

        Cart cart = new Cart();

        cart.setId(sequenceGenerator.generateSequence(Cart.SEQUENCE_NAME));
        cart.setUserId(userid);
        cart.setDate(date);

        // Update the product list
        List<Products> existingProducts = cart.getProduct();

        /**
         * This will check whether there are any existing products in the cart, if not there then this will create a new array.
         */
        if (existingProducts == null) {
            existingProducts = new ArrayList<>();
        }

        /**
         * This .addAll() is used to include all the products that we have provided in the existing products list or if there
         * are no products existing in the cart this will add it newly.
         */
        existingProducts.addAll(products);
        cart.setProduct(existingProducts);

        return cartRepo.save(cart);
    }

//    @Override
//    public Cart updateCart(Integer userid, Date date, List<Products> products, Integer cartid) {
//        return null;
//    }
//
//    @Override
//    public Cart deleteCart(Integer id) {
//        return null;
//    }

}
