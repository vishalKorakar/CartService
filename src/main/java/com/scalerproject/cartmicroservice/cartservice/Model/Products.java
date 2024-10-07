package com.scalerproject.cartmicroservice.cartservice.Model;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    private Integer id;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private Category category;
}
