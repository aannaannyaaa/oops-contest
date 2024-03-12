package com.example.cartSerivce.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.cartSerivce.models.cart;
import com.example.cartSerivce.services.service;

@RestController
public class controller {
    private final service service;
    public controller(service service){
        this.service = service;
    }
    
    
    @GetMapping("/carts/{id}")
    public cart getCartById(@PathVariable("id") Long id) {
        return service.getcartById(id);
    }
    @GetMapping("/carts")
    public cart[] getAllcart(){
        return service.getAllcart();
    }
    @GetMapping("/carts/")
    public cart[] getCartInRangeOfDate(@RequestParam("start-date") String startDate, @RequestParam("end-date") String endDate){
        return service.getcartInRangeOfDate(startDate, endDate);
    }
    @PostMapping("/carts")
    public cart addNewCart(@RequestBody cart cart){
        return service.addNewcart(cart);
    }
    @PatchMapping("/carts/{id}")
    public cart updateCart(@PathVariable("id") Long id,@RequestBody cart cart){
        return service.updatecart(id,cart);
    }
    @DeleteMapping("/carts/{id}")
    public cart deleteCart(@PathVariable("id") Long id){
        return service.deletecart(id);
    }
}