package com.scalerproject.cartmicroservice.cartservice.Service;

import com.scalerproject.cartmicroservice.cartservice.Builder.ProductMapper;
import com.scalerproject.cartmicroservice.cartservice.Model.Cart;
import com.scalerproject.cartmicroservice.cartservice.Model.Products;
import com.scalerproject.cartmicroservice.cartservice.Repository.CartRepo;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service("selfcartservice")
public class SelfCartService implements CartService {

    private final RestTemplate creatRestTemplate;
    private CartRepo cartRepo;
    private SequenceGeneratorService sequenceGenerator;
    private WebClient webClient;
    private ProductMapper productMapper;

    public SelfCartService(CartRepo cartRepo, SequenceGeneratorService sequenceGenerator, WebClient webClient, ProductMapper productMapper, RestTemplate creatRestTemplate) {
        this.cartRepo = cartRepo;
        this.sequenceGenerator = sequenceGenerator;
        this.webClient = webClient;
        this.productMapper = productMapper;
        this.creatRestTemplate = creatRestTemplate;
    }

    @Override
    public Cart getSingleCart(Integer id) {
        Cart singleCart = cartRepo.getCartById(id);
        if (singleCart == null) {
            return null;
        }
        return singleCart;
    }

    @Override
    public List<Cart> getAllCart() {
        List<Cart> allCarts = cartRepo.findAllBy();

        // Validation for whether the cart exists, if not returns null.
        if (allCarts == null) {
            return null;
        }

        return allCarts;
    }

    @Override
    public List<Cart> getCartForUserId(Integer userId) {
        List<Cart> userCart = cartRepo.findByUserId(userId);

        // Validation for whether the cart with user id exists, if not returns null.
        if (userCart == null) {
            return null;
        }

        return userCart;
    }

    @Override
    public Cart addNewCart(Integer userid, Date date, List<Products> products) {

        Cart cart = new Cart();

        cart.setId(sequenceGenerator.generateSequence(Cart.SEQUENCE_NAME));
        cart.setUserId(userid);
        cart.setDate(date);
        cart.setProduct(products);

        // Calling the product service API for getting the product details.
//        Products p = webClient.get()
//                .uri("http://localhost:8080/api/products")
//                .retrieve()
//                .bodyToMono(Products.class)
//                .block();

        return cartRepo.save(cart);
    }

    @Override
    public Cart updateCart(Integer userid, Date date, List<Products> products, Integer cartid) {
        Cart updatedCart = cartRepo.getCartById(cartid);

        if (updatedCart == null) {
            return null;
        }

        // Update the product list
        List<Products> existingProducts = updatedCart.getProduct();
        List<Products> newProd = new ArrayList<>();

        // This for loop checks if a product exists if it exists then it will only change the quantity else it will
        // add entire product as new product.

        for (Products prod : products) {
            int i = 1;
            for (Products exp : existingProducts) {
                if (Objects.equals(exp.getProductId(), prod.getProductId())) {

                    // If the product exists, update the quantity
                    exp.setQuantity(prod.getQuantity());
                    break;
                }
                if (i == existingProducts.size()){
                    newProd.add(prod);
                }
                i++;
            }
        }

        /**
         * This .addAll() is used to include all the products that we have provided in the existing products list or if there
         * are no products existing in the cart this will add it newly.
         */
        existingProducts.addAll(newProd);

        updatedCart.setDate(date);
        updatedCart.setProduct(existingProducts);

        return cartRepo.save(updatedCart);
    }

    @Override
    public Cart deleteCart() {
        Cart cartStatus = new Cart();

        cartStatus.setDeleted(true);
        return cartRepo.save(cartStatus);
    }

}
