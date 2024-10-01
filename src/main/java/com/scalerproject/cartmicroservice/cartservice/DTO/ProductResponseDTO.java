package com.scalerproject.cartmicroservice.cartservice.DTO;

import com.scalerproject.cartmicroservice.cartservice.Model.Products;
import lombok.Getter;
import lombok.Setter;
import org.apache.el.parser.AstPlus;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ProductResponseDTO {
    private long id;
    private Integer userId;
    private Date date;
    private List<Products> AllProducts;
    private boolean status;
}
