package com.scalerproject.cartmicroservice.cartservice.Service;

import com.scalerproject.cartmicroservice.cartservice.Builder.ProductMapper;
import com.scalerproject.cartmicroservice.cartservice.DTO.FakeStoreProductDTO;
import com.scalerproject.cartmicroservice.cartservice.Model.Cart;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakstoreServiceSample implements CartService{

    private RestTemplate restTemplate;
    private ProductMapper mapper;

    public FakstoreServiceSample(RestTemplate restTemplate, ProductMapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    @Override
    public Cart getSingleCart(Integer id) {

        // Calling the fk store api
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.
                getForEntity("https://fakestoreapi.com/carts/" + id,
                        FakeStoreProductDTO.class);

        if (response == null || response.getBody() == null){
            return null;
        }

        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();

        if (fakeStoreProductDTO == null){
            return null;
        }

        return mapper.mapToCart(fakeStoreProductDTO);
    }
}
