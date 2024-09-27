package com.scalerproject.cartmicroservice.cartservice.Controller;

import com.scalerproject.cartmicroservice.cartservice.Builder.ProductMapper;
import com.scalerproject.cartmicroservice.cartservice.DTO.FakestoreProductRequestDTO;
import com.scalerproject.cartmicroservice.cartservice.DTO.ProductRequestDTO;
import com.scalerproject.cartmicroservice.cartservice.DTO.ProductResponseDTO;
import com.scalerproject.cartmicroservice.cartservice.Model.Cart;
import com.scalerproject.cartmicroservice.cartservice.Service.CartService;
//import com.scalerproject.cartmicroservice.cartservice.Service.FakstoreServiceSample;
import com.scalerproject.cartmicroservice.cartservice.Service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController {

    // Dependency Injection
    private CartService crtsvc;
    private SequenceGeneratorService sequenceGenerator;
    private ProductMapper mapper;

    public CartController(@Qualifier("selfcartservice") CartService crtsvc, ProductMapper mapper, SequenceGeneratorService sequenceGenerator) {
        this.crtsvc = crtsvc;
        this.mapper = mapper;
        this.sequenceGenerator = sequenceGenerator;
    }

//    @GetMapping("/carts/{id}")
//    public ProductResponseDTO getSingleCart(@PathVariable("id") Integer id){
//
//        // Validation
//        if (id == null){
//            System.out.println("id is null");
//        }
//
//        // call the fakestore service layer.
//        Cart carts = fksvc.getSingleCart(id);
//
//        // Validation
//        if (id == null){
//            System.out.println("id is not found");
//            return null;
//        }
//
//        return mapper.mapToProductResponseDTO(carts);
//
//    }

//    @GetMapping("/carts")
//    public List<ProductResponseDTO> getAllCart(){
//
//        // call the fakestore service layer.
//        List<Cart> carts = fksvc.getAllCart();
//
//        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();
//
//        // Validation
//        if (carts == null){
//            System.out.println("id is not found");
//            return null;
//        }
//
//        for (Cart c : carts) {
//            productResponseDTOs.add(mapper.mapToProductResponseDTO(c));
//        }
//
//        return productResponseDTOs;
//    }
//
//    @GetMapping("carts/user/{userid}")
//    public List<ProductResponseDTO> getCartForUserId(@PathVariable("userid") Integer userid){
//
//        if (userid == null){
//            // Throws Error
//        }
//
//        List<Cart> userCarts = fksvc.getCartForUserId(userid);
//
//        List<ProductResponseDTO> dto = new ArrayList<>();
//
//        if (userCarts == null){
//            return null;
//        }
//
//        for (Cart c : userCarts) {
//            dto.add(mapper.mapToProductResponseDTO(c));
//        }
//
//        return dto;
//    }

    @PostMapping("/carts")
    public ProductResponseDTO addNewCart(@RequestBody ProductRequestDTO dto){

        if (dto.getUserId() == null || dto.getDate() == null || dto.getProducts() == null){
            System.out.println("please give information to add in the database");
            return null;
        }

        Cart addProduct = crtsvc.addNewCart(dto.getUserId(), dto.getDate(), dto.getProducts());

        return mapper.mapToProductResponseDTO(addProduct);
    }

//    @PostMapping("/carts/{cartid}")
//    public ProductResponseDTO updateCart(@RequestBody FakestoreProductRequestDTO dto, @PathVariable("cartid") Integer cartid){
//
//        if (dto == null){
//            return null;
//        }
//
//        Cart update = fksvc.updateCart(dto.getUserId(), dto.getDate(), dto.getProductsList(), cartid);
//
//        if (update == null){
//            return null;
//        }
//
//        return mapper.mapToProductResponseDTO(update);
//    }
//
//    @DeleteMapping("/carts/{cartid}")
//    public ProductResponseDTO deleteCart(@PathVariable("cartid") Integer cartid){
//
//        if (cartid == null){
//            return null;
//        }
//
//        Cart deleteCart = fksvc.deleteCart(cartid);
//
//        if (deleteCart == null){
//            return null;
//        }
//        return mapper.mapToProductResponseDTO(deleteCart);
//    }
}
