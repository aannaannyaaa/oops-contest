package com.example.cartSerivce.models;
    import lombok.Getter;
    import lombok.Setter;

    import java.util.Date;

    @Getter
    @Setter

    public class cart {
    private Long id ;
    private Long userId;
    private Date date;
    private product[] product;
    }

