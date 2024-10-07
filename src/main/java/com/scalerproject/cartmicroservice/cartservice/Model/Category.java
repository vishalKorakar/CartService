package com.scalerproject.cartmicroservice.cartservice.Model;



import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
    private Integer categoryId;
    private String title;
}
