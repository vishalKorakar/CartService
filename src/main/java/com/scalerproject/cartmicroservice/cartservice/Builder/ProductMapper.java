package com.scalerproject.cartmicroservice.cartservice.Builder;

import com.scalerproject.cartmicroservice.cartservice.DTO.FakeStoreProductDTO;
import com.scalerproject.cartmicroservice.cartservice.DTO.ProductResponseDTO;
import com.scalerproject.cartmicroservice.cartservice.Model.Cart;
import com.scalerproject.cartmicroservice.cartservice.Model.Products;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProductMapper {

//    public Cart mapToCart(FakeStoreProductDTO fakeStoreProductDTO){
//        Cart carts = new Cart();
//
//        FakeStoreProductDTO[] dto = new FakeStoreProductDTO[fakeStoreProductDTO.getProducts().size()];
//        List<Products> productsList = new ArrayList<>();
//
//        for (int i = 0; i < fakeStoreProductDTO.getProducts().size(); i++) {
//            Products products = new Products();
//            products.setProductId(fakeStoreProductDTO.getProducts().get(i).getProductId());
//            products.setQuantity(fakeStoreProductDTO.getProducts().get(i).getQuantity());
//
//            productsList.add(products);
//        }
//
//        carts.setId(fakeStoreProductDTO.getId());
//        carts.setUserId(fakeStoreProductDTO.getUserId());
//        carts.setDate(fakeStoreProductDTO.getDate());
//        carts.setProduct(productsList);
//
////        System.out.print(carts);
//
//        return carts;
//    }

    public ProductResponseDTO mapToProductResponseDTO(Cart cart){
        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(cart.getId());
        dto.setUserId(cart.getUserId());
        dto.setDate(cart.getDate());
        dto.setAllProducts(cart.getProduct());
        dto.setStatus(cart.getIsDeleted());

        return dto;
    }
}
