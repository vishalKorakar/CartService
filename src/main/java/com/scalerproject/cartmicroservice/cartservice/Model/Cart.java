package com.scalerproject.cartmicroservice.cartservice.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Getter
@Setter
public class Cart {

    private Integer id;
    private Integer userId;
    private Date date;
    // this will be called from the Product Service

    private List<Products> product; // This information will be coming from the productService microservice.
}
