package com.scalerproject.cartmicroservice.cartservice.Model;

import lombok.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Document(collection = "cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Transient
    public static final String SEQUENCE_NAME = "cart_sequence";

    @Id
    private Long id;
    private Integer userId;
    private Date date;
    private List<Products> product;
}
