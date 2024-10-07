package com.scalerproject.cartmicroservice.cartservice.DTO;

import com.scalerproject.cartmicroservice.cartservice.Model.ProductQuantity;
import com.scalerproject.cartmicroservice.cartservice.Model.Products;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
public class ProductRequestDTO {
    private Integer userId;
    private Date date;
    private List<ProductQuantity> products;
}


