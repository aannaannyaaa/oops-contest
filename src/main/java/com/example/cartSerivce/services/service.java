package com.example.cartSerivce.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.cartSerivce.dto.cartdto;
import com.example.cartSerivce.models.cart;

@Service
public class service implements cartInterface {
     RestTemplate restTemplate = new RestTemplate();
    @Override
    public cart getcartById(Long id) {
        cartdto cartDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/"+id,
                cartdto.class);
        cart cart = new cart();
        cart.setId(cartDTO.getId());
        cart.setDate(cartDTO.getDate());
        cart.setUserId(cartDTO.getUserId());
        cart.setProduct(cartDTO.getProducts());
        return cart;


    }
    @Override
    public cart[] getAllcart() {
        cartdto[] cartDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/carts",
                cartdto[].class);
        cart[] cartList = new cart[cartDTO.length];
        for (int i = 0; i < cartDTO.length; i++) {
            cartList[i] = new cart();
            cartList[i].setId(cartDTO[i].getId());
            cartList[i].setUserId(cartDTO[i].getUserId());
            cartList[i].setDate(cartDTO[i].getDate());
            cartList[i].setProduct(cartDTO[i].getProducts());
        }
        return cartList;
    }
    @Override
    public cart[] getcartInRangeOfDate(String startDate, String endDate) {
        cartdto[] cartDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/carts?startdate="+startDate+"&enddate="+endDate,
                cartdto[].class);
        cart[] cartListByDate = new cart[cartDTO.length];
        for (int i = 0; i < cartDTO.length; i++) {
            cartListByDate[i] = new cart();
            cartListByDate[i].setId(cartDTO[i].getId());
            cartListByDate[i].setUserId(cartDTO[i].getUserId());
            cartListByDate[i].setProduct(cartDTO[i].getProducts());
            cartListByDate[i].setDate(cartDTO[i].getDate());
        }
        return cartListByDate;
    }
    @Override
    public cart[] getcartByUserId(Long userId) {
        cartdto[] cartDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/user/"+userId,
                cartdto[].class);
        cart[] cartListByUserId = new cart[cartDTO.length];
        for (int i = 0; i < cartDTO.length; i++) {
            cartListByUserId[i] = new cart();
            cartListByUserId[i].setId(cartDTO[i].getId());
            cartListByUserId[i].setUserId(cartDTO[i].getUserId());
            cartListByUserId[i].setProduct(cartDTO[i].getProducts());
            cartListByUserId[i].setDate(cartDTO[i].getDate());

        }
        return cartListByUserId;
    }

    public cart addNewcart(cart cart) {
        cartdto cartDTO = new cartdto();
        cartDTO.setId(cart.getId());
        cartDTO.setUserId(cart.getUserId());
        cartDTO.setDate(cart.getDate());
        cartDTO.setProducts(cart.getProduct());

        restTemplate.postForEntity(
                "https://fakestoreapi.com/carts",
                cartDTO,
                cartdto.class);

        return cart;
    }
    @Override
    public cart updatecart(Long id,cart cart) {
        cart oldcart = getcartById(id);
        cartdto newcart = new cartdto();
        newcart.setId(oldcart.getId());
        newcart.setUserId(oldcart.getUserId());
        newcart.setDate(oldcart.getDate());
        newcart.setProducts(oldcart.getProduct());

        restTemplate.postForEntity(
                "https://fakestoreapi.com/carts",
                newcart,
                cart.class);
        return cart;
    }
    @Override
    public cart deletecart(Long id) {
        cart getcart = getcartById(id);
        restTemplate.delete("https://fakestoreapi.com/carts/"+id);
        return getcart;
    }
}
