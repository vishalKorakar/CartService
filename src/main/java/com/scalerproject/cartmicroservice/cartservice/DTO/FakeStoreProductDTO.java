package com.scalerproject.cartmicroservice.cartservice.DTO;

import com.scalerproject.cartmicroservice.cartservice.Model.Products;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


/**
 * This DTO is to convert the response from fakestore api.
*/

@Getter
@Setter
public class FakeStoreProductDTO {
    private Integer id;
    private Integer userId;
    private Date date;
    private List<Products> products;

}
