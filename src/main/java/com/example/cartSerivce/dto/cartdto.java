package com.example.cartSerivce.dto;
import com.example.cartSerivce.models.product;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;


@Getter
@Setter
public class cartdto {
    private Long id;
    private Long userId;
    private Date date;
    private product[] products;

}
