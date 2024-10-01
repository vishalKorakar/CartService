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

    @GetMapping("/carts/{id}")
    public ProductResponseDTO getSingleCart(@PathVariable("id") Integer id) throws Exception {

        // Validation
        if (id == null){
            throw new Exception("please enter a valid id");
        }

        // call our own database layer.
        Cart carts = crtsvc.getSingleCart(id);

        // Validation
        if (id == null){
            throw new Exception("id is not found");
        }

        return mapper.mapToProductResponseDTO(carts);

    }

    @GetMapping("/carts")
    public List<ProductResponseDTO> getAllCart() throws Exception {

        // call the cart service layer.
        List<Cart> carts = crtsvc.getAllCart();

        List<ProductResponseDTO> productResponseDTOs = new ArrayList<>();

        // Validation
        if (carts == null){
            throw new Exception("carts does not exist.");
        }

        for (Cart c : carts) {
            productResponseDTOs.add(mapper.mapToProductResponseDTO(c));
        }

        return productResponseDTOs;
    }

    @GetMapping("carts/user/{userid}")
    public List<ProductResponseDTO> getCartForUserId(@PathVariable("userid") Integer userid) throws Exception {

        if (userid == null){
            // Throws Error
        }

        List<Cart> userCarts = crtsvc.getCartForUserId(userid);

        List<ProductResponseDTO> dto = new ArrayList<>();

        if (userCarts == null){
            throw new Exception("Carts with the provided user id does not exist");
        }

        for (Cart c : userCarts) {
            dto.add(mapper.mapToProductResponseDTO(c));
        }

        return dto;
    }

    @PostMapping("/carts")
    public ProductResponseDTO addNewCart(@RequestBody ProductRequestDTO dto){

        if (dto.getUserId() == null || dto.getDate() == null || dto.getProducts() == null){
            System.out.println("please give information to add in the database");
            return null;
        }

        Cart addProduct = crtsvc.addNewCart(dto.getUserId(), dto.getDate(), dto.getProducts());

        return mapper.mapToProductResponseDTO(addProduct);
    }

    @PutMapping("/carts/{cartid}")
    public ProductResponseDTO updateCart(@RequestBody ProductRequestDTO dto, @PathVariable("cartid") Integer cartid){

        if (dto == null){
            return null;
        }

        Cart update = crtsvc.updateCart(dto.getUserId(), dto.getDate(), dto.getProducts(), cartid);

        if (update == null){
            return null;
        }

        return mapper.mapToProductResponseDTO(update);
    }

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
