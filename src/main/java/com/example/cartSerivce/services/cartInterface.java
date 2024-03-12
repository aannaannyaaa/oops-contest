package com.example.cartSerivce.services;

import com.example.cartSerivce.models.cart;

public interface cartInterface {
    public cart getcartById(Long id);
    public cart[] getAllcart();
    public cart[] getcartInRangeOfDate(String startDate, String endDate);
    public cart[] getcartByUserId(Long userId);
    public cart addNewcart(cart cart);
    public cart updatecart(Long id,cart cart);
    public cart deletecart(Long id);
}
