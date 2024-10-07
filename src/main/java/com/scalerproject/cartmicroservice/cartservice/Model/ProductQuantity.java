package com.scalerproject.cartmicroservice.cartservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductQuantity {
    private Integer productId;
    private Integer quantity;
}
