/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp2.infrastructure.entity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import upeu.edu.pe.lp2.app.service.OrderService;
import upeu.edu.pe.lp2.infrastructure.entity.OrderEntity;
import upeu.edu.pe.lp2.infrastructure.entity.UserEntity;

/**
 *
 * @author Aarón López
 */

@RestController
@RequestMapping("/api/v1/order/")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save-order")
    public String saveOrder (@RequestBody OrderEntity orderEntity){
        return orderService.saveOrder(orderEntity).toString();

    }

    @GetMapping("/show")
    public Iterable <OrderEntity> showMatricula(){
        UserEntity user = new UserEntity();
        user.setId(1);
        return orderService.getOrdersByUser(user);
    }

    @GetMapping("/show/{id}")
    public OrderEntity show(@PathVariable Integer id){
        return orderService.getOrderById(id);
    }


    //eliminar un product
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrderById(id);
    }


}