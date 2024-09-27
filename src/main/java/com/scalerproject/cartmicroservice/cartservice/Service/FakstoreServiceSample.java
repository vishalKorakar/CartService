//package com.scalerproject.cartmicroservice.cartservice.Service;
//
//import com.scalerproject.cartmicroservice.cartservice.Builder.ProductMapper;
//import com.scalerproject.cartmicroservice.cartservice.DTO.FakeStoreProductDTO;
//import com.scalerproject.cartmicroservice.cartservice.DTO.FakestoreProductRequestDTO;
//import com.scalerproject.cartmicroservice.cartservice.Model.Cart;
//import com.scalerproject.cartmicroservice.cartservice.Model.Products;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class FakstoreServiceSample implements CartService{
//
//    private RestTemplate restTemplate;
//    private ProductMapper mapper;
//
//    public FakstoreServiceSample(RestTemplate restTemplate, ProductMapper mapper) {
//        this.restTemplate = restTemplate;
//        this.mapper = mapper;
//    }
//
//    @Override
//    public Cart getSingleCart(Integer id) {
//        try {
//            // Log the API call
//            System.out.println("Calling Fakestore API with cart ID: " + id);
//
//            // Calling the Fakestore API
//            ResponseEntity<FakeStoreProductDTO> response = restTemplate
//                    .getForEntity("https://fakestoreapi.com/carts/" + id, FakeStoreProductDTO.class);
//
//            // Check if response is not null
//            if (response == null || response.getBody() == null) {
//                System.out.println("No response or empty body from Fakestore API.");
//                return null;
//            }
//
//            FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
//
//            /**
//             * Log response details
//             * System.out.println("Response Status Code: " + response.getStatusCode());
//             * System.out.println("Response Body: " + response.getBody());
//             * System.out.println("Response Body Id: " + fakeStoreProductDTO.getId());
//             * System.out.println("Response Body userId: " + fakeStoreProductDTO.getUserId());
//             * System.out.println("Response Body Date: " + fakeStoreProductDTO.getDate());
//             * System.out.println("Response Body Products: " + fakeStoreProductDTO.getProducts());
//             * */
//
//            // Map response DTO to Cart model
//            return mapper.mapToCart(fakeStoreProductDTO);
//
//        } catch (RestClientException e) {
//            // Log the exception if the API call fails
//            System.out.println("Error while calling Fakestore API: " + e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public List<Cart> getAllCart() {
//
//        try {
//            // Log the API call
//            System.out.println("Calling Fakestore API with cart");
//
//            List<Cart> cartsList = new ArrayList<>();
//
//            // Calling the Fakestore API
//            ResponseEntity<FakeStoreProductDTO[]> response = restTemplate
//                    .getForEntity("https://fakestoreapi.com/carts", FakeStoreProductDTO[].class);
//
//            // Check if response is not null
//            if (response == null || response.getBody() == null) {
//                System.out.println("No response or empty body from Fakestore API.");
//                return null;
//            }
//
//            FakeStoreProductDTO[] fakeStoreProductDTO = response.getBody();
//
//
//            for (FakeStoreProductDTO dto : fakeStoreProductDTO) {
//                Cart carts = mapper.mapToCart(dto);
//                cartsList.add(carts);
//            }
//
//            return cartsList;
//
//        } catch (RestClientException e) {
//            // Log the exception if the API call fails
//            System.out.println("Error while calling Fakestore API: " + e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public List<Cart> getCartForUserId(Integer userid) {
//
//        List<Cart> userList = new ArrayList<>();
//
//        // Calling the Fakestore API
//        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate
//                .getForEntity("https://fakestoreapi.com/carts/user/" + userid, FakeStoreProductDTO[].class);
//
//        // Check if response is not null
//        if (response == null || response.getBody() == null) {
//            System.out.println("No response or empty body from Fakestore API.");
//            return null;
//        }
//
//        FakeStoreProductDTO[] fakeStoreProductDTO = response.getBody();
//
//
//        for (FakeStoreProductDTO dto : fakeStoreProductDTO) {
//            Cart carts = mapper.mapToCart(dto);
//            userList.add(carts);
//        }
//
//        return userList;
//    }
//
//    @Override
//    public Cart addNewProductToCart(Integer userid, Date date, List<Products> products) {
//
//        FakeStoreProductDTO requestBody = new FakeStoreProductDTO();
//
//        requestBody.setUserId(userid);
//        requestBody.setDate(date);
//        requestBody.setProducts(products);
//
//        // S2. Call FakeStore API
//        FakeStoreProductDTO response = restTemplate.postForObject(
//                "https://fakestoreapi.com/carts",
//                requestBody, FakeStoreProductDTO.class);
//
//
//        // S3. Get ProductModel
//        Cart cartModel = mapper.mapToCart(response);
//
//        // S4. Return Product
//        return cartModel;
//    }
//
//    @Override
//    public Cart updateCart(Integer userid, Date date, List<Products> products, Integer cartid) {
//
//        FakeStoreProductDTO requestBody = new FakeStoreProductDTO();
//
//        requestBody.setUserId(userid);
//        requestBody.setDate(date);
//        requestBody.setProducts(products);
//
//        // S2. Call FakeStore API
//        FakeStoreProductDTO response = restTemplate.postForObject(
//                "https://fakestoreapi.com/carts/" + cartid,
//                requestBody, FakeStoreProductDTO.class);
//
//        System.out.println(response);
//
//        // S3. Get ProductModel
//        Cart cartModel = mapper.mapToCart(response);
//
//        // S4. Return Product
//        return cartModel;
//    }
//
//    public Cart deleteCart(Integer id) {
////        FakeStoreProductDTO requestBody = new FakeStoreProductDTO();
//
////        requestBody.setUserId(id);
//
////        FakeStoreProductDTO response = restTemplate.postForObject(
////                "https://fakestoreapi.com/carts",
////                requestBody, FakeStoreProductDTO.class);
//
//        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(
//                "https://fakestoreapi.com/carts",
//                FakeStoreProductDTO.class);
//        // S3. Get ProductModel
//        FakeStoreProductDTO responseBody = response.getBody();
//
//        // S4. Return Product
//        return mapper.mapToCart(responseBody);
//    }
//
//}
