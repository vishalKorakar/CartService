package com.scalerproject.cartmicroservice.cartservice.Controller;

import com.scalerproject.cartmicroservice.cartservice.Builder.ProductMapper;
import com.scalerproject.cartmicroservice.cartservice.DTO.FakeStoreProductDTO;
import com.scalerproject.cartmicroservice.cartservice.DTO.ProductResponseDTO;
import com.scalerproject.cartmicroservice.cartservice.Model.Cart;
import com.scalerproject.cartmicroservice.cartservice.Model.Products;
import com.scalerproject.cartmicroservice.cartservice.Service.CartService;
import com.scalerproject.cartmicroservice.cartservice.Service.FakstoreServiceSample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController {

    // Dependency Injection
//    private CartService cartService;
    private FakstoreServiceSample fksvc;
    private ProductMapper mapper;

    public CartController(FakstoreServiceSample fksvc, FakstoreServiceSample fakstoreServiceSample, ProductMapper mapper) {
        this.fksvc = fksvc;
        this.mapper = mapper;
    }

    @GetMapping("/carts/{id}")
    public ProductResponseDTO getSingleCart(@PathVariable("id") Integer id){

        // Validation
        if (id == null){
            System.out.println("id is null");
        }

        // call the fakestore service layer.
        Cart carts = fksvc.getSingleCart(id);

        // Validation
        if (id == null){
            System.out.println("id is not found");
            return null;
        }

        return mapper.mapToProductResponseDTO(carts);

    }

    @GetMapping("/carts")
    public List<ProductResponseDTO> getAllCart(){

        // call the fakestore service layer.
        List<Cart> carts = fksvc.getAllCart();

        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();

        // Validation
        if (carts == null){
            System.out.println("id is not found");
            return null;
        }

        for (Cart c : carts) {
            productResponseDTOs.add(mapper.mapToProductResponseDTO(c));
        }

        return productResponseDTOs;
    }
}
