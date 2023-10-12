/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp2.app.service;

import upeu.edu.pe.lp2.app.repository.OrderRepository;
import upeu.edu.pe.lp2.infrastructure.entity.OrderEntity;
import upeu.edu.pe.lp2.infrastructure.entity.UserEntity;


/**
 *
 * @author Aarón López
 */

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Iterable<OrderEntity> getOrders(){
        return orderRepository.getOrders();
    }
    public Iterable<OrderEntity> getOrdersByUser(UserEntity user){
        return orderRepository.getOrdersByUser(user);
    }
    public OrderEntity getOrderById(Integer id){
        return orderRepository.getOrderById(id);
    }
    public OrderEntity saveOrder(OrderEntity order) {
        return orderRepository.saveOrder(order);
    }
    public void deleteOrderById(Integer id){
        orderRepository.deleteProductById(id);
    }
}